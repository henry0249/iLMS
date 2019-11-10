package com.hotent.mini.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanthink.pub.manager.PubSupplierManager;
import com.hanthink.pub.model.PubSupplierModel;
import com.hotent.base.core.util.AppUtil;
import com.hotent.base.core.util.string.StringUtil;
import com.hotent.base.core.web.CookieUitl;
import com.hotent.base.core.web.RequestUtil;
import com.hotent.base.persistence.manager.CacheUtil;
import com.hotent.mini.controller.LoginController.LoginResult;
import com.hotent.mini.web.context.SubSystemUtil;
import com.hotent.mini.web.security.HtSwitchUserFilter;
import com.hotent.mini.web.security.SecurityUtil;
import com.hotent.org.api.model.IUser;
import com.hotent.org.api.service.IUserService;
import com.hotent.sys.api.auth.IAuthService;
import com.hotent.sys.api.auth.IAuthUser;
import com.hotent.sys.util.SysPropertyUtil;

@Controller
public class LoginController {
	@Resource
	AuthenticationManager authenticationManager;
	@Resource
	IUserService userService;
	//@Resource
	SessionAuthenticationStrategy sessionStrategy= new NullAuthenticatedSessionStrategy();
	@Resource
	IAuthService authService;
	
	private  String defaultLogin="/login";
	

	@RequestMapping(value = "/login/valid", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request, HttpServletResponse response) {
		
		String referer=request.getHeader("Referer");
		if(referer.indexOf("mobile")>-1){
			CookieUitl.addCookie("loginAction", "mobile", true, request, response);
		}
		
		
		String account = RequestUtil.getString(request, "account");
		String password = RequestUtil.getString(request, "password");
		if(StringUtil.isEmpty(account)){
			return new LoginResult(false, null ,"账号不能为空.");
		}
		if(StringUtil.isEmpty(password)){
			return new LoginResult(false, null ,"密码不能为空.");
		}
		
		String systemId = SubSystemUtil.getSystemId(request);
		
		//删除切换用户标识
		CookieUitl.delCookie(HtSwitchUserFilter.SwitchAccount, request, response);
		try {
			
			IUser user = userService.getUserByAccount(account);
			Authentication auth = SecurityUtil.login(request, account, password, false);
			
			sessionStrategy.onAuthentication(auth, request, response);
			//增加用户类型判断，若为供应商用户需判断供应商状态
			if(IUser.USER_TYPE_SUPP.equals(user.getUserType())){
				if(StringUtil.isEmpty(user.getSupplierNo())){
					return new LoginResult(false, null ,"没有供应商代码.");
				}
				PubSupplierManager supManager = AppUtil.getBean(PubSupplierManager.class);
				PubSupplierModel tmpSup = new PubSupplierModel();
				tmpSup.setSupplierNo(user.getSupplierNo());
				PubSupplierModel sup = supManager.querySupplierBySupplierNo(tmpSup);
				if(null == sup){
					return new LoginResult(false, null ,"供应商【" + user.getSupplierNo() + "】不存在！");
				}
				
				//新增供应商激活状态判断,需要截取登录账号的前5位为供应商代码，后1位为出货地
				try {
					Integer count = userService.querySupplierAccountStatus(account);
					if(count != 1){
						String uid = authService.setAuth(user);
						IAuthUser authUser = authService.getByUid(uid);
						
						//根据系统属性表配置的后台服务地址，将token信息保存到其它后台服务
						String serverUrlVal = SysPropertyUtil.getByAlias("sys.serverUrl", "");
						if(StringUtil.isNotEmpty(serverUrlVal)){
							String[] serverUrlArr = serverUrlVal.split(",");
							String localip = "";
							try {
								localip = InetAddress.getLocalHost().getHostAddress().toString();
							} catch (Exception e) {
								e.printStackTrace();
							}
							for(String serverUrl : serverUrlArr){
								if(null != serverUrl && serverUrl.indexOf(localip) < 0){
									saveTokenToOtherServer(serverUrl, authUser, uid);
								}
							}
						}
						
						return new LoginResult(false, account, authUser.getTokenValue(), "供应商【" + user.getSupplierNo() + "】未激活！");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
//				if(!PubSupplierModel.SUP_STATUS_ACT.equals(sup.getSupStatus())){
//				    return new LoginResult(false, account, authUser.getTokenValue(), "供应商【" + user.getSupplierNo() + "】未激活！");
//				}
			}
			
			String uid = authService.setAuth(user);
			if(authService.isCluster()){
				//共享session
				SecurityUtil.addSessionId2Cache(request, account);
			}
			//执行记住密码动作。
			SecurityUtil.writeRememberMeCookie( request,  response,  account,password);
			
			//清除资源缓存
			CacheUtil.cleanCache(CacheUtil.RESOURCE_USER_RES + systemId + user.getUserId());
			CacheUtil.cleanCache(CacheUtil.RESOURCE_REQ_USER_RES + systemId + user.getUserId());
			
			IAuthUser authUser = authService.getByUid(uid);
			
			//根据系统属性表配置的后台服务地址，将token信息保存到其它后台服务
			String serverUrlVal = SysPropertyUtil.getByAlias("sys.serverUrl", "");
			if(StringUtil.isNotEmpty(serverUrlVal)){
				String[] serverUrlArr = serverUrlVal.split(",");
				String localip = "";
				try {
					localip = InetAddress.getLocalHost().getHostAddress().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for(String serverUrl : serverUrlArr){
			        if(null != serverUrl && serverUrl.indexOf(localip) < 0){
			        	saveTokenToOtherServer(serverUrl, authUser, uid);
			        }
				}
			}
			
			return new LoginResult(true, uid, authUser.getTokenValue(), "登陆成功");
		} catch (BadCredentialsException e) {
			return new LoginResult(false, null ,"账号或密码错误.");
		}
		catch (DisabledException e) {
			return new LoginResult(false, null ,"帐号被禁用.");
		}
		catch (LockedException e) {
			return new LoginResult(false, null ,"帐号被锁定.");
		}
		catch (AccountExpiredException e) {
			return new LoginResult(false, null ,"帐号过期.");
		}
		catch(Exception ex){
			return new LoginResult(false, null ,ex.getMessage());
		}
	}
	
	/**
	 * 服务端认证，记录token信息
	 * @param request
	 * @param response
	 * @return
	 * @author ZUOSL	
	 * @DATE	2019年4月12日 下午6:24:53
	 */
	@RequestMapping(value = "/login/validServer", method = RequestMethod.POST)
	@ResponseBody
	public Object loginServer(HttpServletRequest request, HttpServletResponse response) {
		
		String account = RequestUtil.getString(request, "account");
		String uid = RequestUtil.getString(request, "uid");
		String token = RequestUtil.getString(request, "tokenVal");
		if(StringUtil.isEmpty(account) || StringUtil.isEmpty(uid) || StringUtil.isEmpty(token)){
			return new LoginResult(false, null ,"参数获取不全.");
		}
		
		String systemId = SubSystemUtil.getSystemId(request);
		
		//删除切换用户标识
		CookieUitl.delCookie(HtSwitchUserFilter.SwitchAccount, request, response);
		try {
			
			IUser user = userService.getUserByAccount(account);
			Authentication auth = SecurityUtil.login(request, account, "", true);
			sessionStrategy.onAuthentication(auth, request, response);
			authService.setAuth(user, uid, token);
			if(authService.isCluster()){
				//共享session
				SecurityUtil.addSessionId2Cache(request, account);
			}
			
			//清除资源缓存
			CacheUtil.cleanCache(CacheUtil.RESOURCE_USER_RES + systemId + user.getUserId());
			CacheUtil.cleanCache(CacheUtil.RESOURCE_REQ_USER_RES + systemId + user.getUserId());
			
			IAuthUser authUser = authService.getByUid(uid);
			return new LoginResult(true, uid, authUser.getTokenValue(), "登陆成功");
		} catch (BadCredentialsException e) {
			return new LoginResult(false, null ,"账号或密码错误.");
		}
		catch (DisabledException e) {
			return new LoginResult(false, null ,"帐号被禁用.");
		}
		catch (LockedException e) {
			return new LoginResult(false, null ,"帐号被锁定.");
		}
		catch (AccountExpiredException e) {
			return new LoginResult(false, null ,"帐号过期.");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new LoginResult(false, null ,ex.getMessage());
		}
	}
	
	/**
	 * 保存认证信息到其它后台服务
	 * @param serverUrl
	 * @param authUser
	 * @param uid
	 * @author ZUOSL	
	 * @DATE	2019年4月13日 下午2:33:25
	 */
	private static String saveTokenToOtherServer(String serverUrl, IAuthUser authUser, String uid) {

		try {
			String reqUrl = serverUrl + "/login/validServer";
			StringBuffer param = new StringBuffer();
			param.append("account=");
			param.append(authUser.getUser().getAccount());
			param.append("&uid=");
			param.append(uid);
			param.append("&tokenVal=");
			param.append(authUser.getTokenValue());
			
			return post(reqUrl, param.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginRedirect")
	public void loginRedirect(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String loginAction=CookieUitl.getValueByName("loginAction", request);
		String redirectUrl="";
		Map<String,String> actionPageMap=(Map<String,String>)AppUtil.getBean("actionPageMap");
		if(StringUtil.isNotEmpty(loginAction) && actionPageMap.containsKey(loginAction)){
			//删除cookie
			CookieUitl.delCookie("loginAction", request, response);
			redirectUrl=actionPageMap.get(loginAction);
			response.sendRedirect(request.getContextPath() +redirectUrl);
			return ;
		}
		response.sendRedirect(request.getContextPath() +this.defaultLogin);
		
	}

	public class LoginResult {
		private final boolean success;
		
		private final String username;
		private final String message;
		private String token;

		public LoginResult(boolean success, String username,String message) {
			this.success = success;
			this.username = username;
			this.message = message;
		}
		
		public LoginResult(boolean success, String username, String token, String message) {
			this.success = success;
			this.username = username;
			this.token = token;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getUsername() {
			return username;
		}
		
		public String getMessage() {
			return message;
		}
		public String getToken(){
			return this.token;
		}
	}
	
	public static String post(String URL, String parm) {

        HttpURLConnection conn = null;
        DataOutputStream dataOut = null;
        BufferedReader dataIn = null;

        try {
            URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Referer", "http://xxxx.xxx.com");
            conn.addRequestProperty("User-Agent", "");

            conn.connect();
            dataOut = new DataOutputStream(conn.getOutputStream());
            dataOut.writeBytes(parm != null ? parm : "");
            dataOut.flush();

            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = dataIn.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataOut != null) {
                    dataOut.close();
                }
                if (dataIn != null) {
                    dataIn.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
}