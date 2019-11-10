package com.hotent.base.authimpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.hotent.base.core.cache.ICache;
import com.hotent.base.core.cache.impl.MemoryCache;
import com.hotent.base.core.util.PropertyUtil;
import com.hotent.mini.web.security.SecurityUtil;
import com.hotent.org.api.model.IUser;
import com.hotent.sys.api.auth.IAuthService;
import com.hotent.sys.api.auth.IAuthUser;

public class AuthService implements IAuthService {
	
	private Map<String, IAuthUser> map=Collections.synchronizedMap( new HashMap<String, IAuthUser>());
	
	private Integer _isClusterInt = -1;
	@Resource
	ICache<String> icache;
	
	@Override
	public String setAuth(IUser user) {
		
		String id = UUID.randomUUID().toString().replace("-", ""); 
//		String id = user.getAccount(); //直接使用用户名账号作为ID 同一用户只允许一处登录使用
		
		//方便开发，admin允许多处登录
		//属性参数指定允许多处登录的账号
//		String[] allowLoginArr = SysPropertyUtil.getByAlias("system.allowMultipleLoginAccount", "").split(",");
//		Set<String> set = null;
//		if(null != allowLoginArr){
//			if(!(allowLoginArr.length == 1 && "".equals(allowLoginArr[0]))){
//				set = new HashSet<String>();
//				for(String allowAccount : allowLoginArr){
//					set.add(allowAccount);
//				}
//			}
//		}
//		if(user.isAdmin() 
//				|| ( null != set && set.contains(user.getAccount()) ) ){
//			id = UUID.randomUUID().toString().replace("-", "");
//		}
		
		
		//生成token信息
		long tokenExpiryTime = System.currentTimeMillis() + 24 * 3600 * 1000; //有效期 1 天
		String tokenValue = SecurityUtil.generateLoginToken(id, user.getAccount(), user.getPassword(), tokenExpiryTime);
		
		IAuthUser authuser = new AuthUser(user, tokenValue);
		authuser.resetTimeout();
		map.put(id, authuser);
		return id;
	}

	@Override
	public IAuthUser getByUid(String uid) {
		if(!map.containsKey(uid)) return null;
		IAuthUser user= map.get(uid);
		if(user.isTimeOut()){
			map.remove(uid);
		}
		return user;
	}

	@Override
	public String getClientUrlByAppId(String appId) {
		String json=PropertyUtil.getProperty("appConfig");
		JSONObject jsonObj=JSONObject.parseObject(json);
		JSONObject appJson= jsonObj.getJSONObject(appId);
		return appJson.getString("url");
	}

	@Override
	public String getReturnUrlByAppId(String appId) {
		String json=PropertyUtil.getProperty("appConfig");
		JSONObject jsonObj=JSONObject.parseObject(json);
		JSONObject appJson= jsonObj.getJSONObject(appId);
		return appJson.getString("returnUrl");
	}

	@Override
	public Boolean isCluster() {
		if(this._isClusterInt > -1){
			return this._isClusterInt==1;
		}
		if(icache instanceof MemoryCache){
			_isClusterInt = 0;
		}
		else{
			_isClusterInt = 1;
		}
		return _isClusterInt==1;
	}
	
	/**
	 * 根据UID和token直接保存认证信息，服务端分布式部署使用
	 * @param user
	 * @param uid
	 * @param token
	 * @return
	 * @DATE	2019年4月13日 下午2:14:35
	 */
	@Override
	public String setAuth(IUser user, String uid, String tokenValue) {
		IAuthUser authuser = new AuthUser(user, tokenValue);
		authuser.resetTimeout();
		map.put(uid, authuser);
		return uid;
	}
	
	
	AuthService(){
		
		try {
			
			//清理超时的用户信息
			new Timer().schedule(new TimerTask() { 
		      @Override
		      public void run() { 
		    	  try {
		    		  if(null != map){
		    			  for(String tUid : map.keySet()){
		    				  IAuthUser au = map.get(tUid);
		    				  if(null!= au && au.isTimeOut()){
		    					  map.remove(tUid);
		    				  }
		    			  }
		    		  }
				} catch (Exception e) {
					
				}
		      } 
		    },60*3600, 600*3600); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
