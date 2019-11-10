package com.hanthink.sw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hanthink.business.util.SessionKey;
import com.hanthink.sw.manager.SwSupplierGroupManager;
import com.hanthink.sw.model.SwSupplierGroupModel;
import com.hanthink.sw.model.SwSupplierGroupModelImport;
import com.hanthink.util.excel.ExcelUtil;
import com.hotent.base.api.Page;
import com.hotent.base.api.model.ResultMessage;
import com.hotent.base.api.query.QueryFilter;
import com.hotent.base.core.util.string.StringUtil;
import com.hotent.base.core.web.GenericController;
import com.hotent.base.core.web.RequestUtil;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageJson;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.org.api.model.IUser;
import com.hotent.sys.util.ContextUtil;
import com.hotent.sys.util.SysPropertyUtil;

import net.sf.json.JSONObject;

/**
* <p>Title: SwSupplierGroupController.java<／p>
* <p>Description: <／p>
* <p>Company: hanthink<／p>
* @author luoxq
* @date 2018年10月11日
*/
@Controller
@RequestMapping("/sw/swSupplierGroup")
public class SwSupplierGroupController extends GenericController{

	@Resource
	private SwSupplierGroupManager swSupplierGroupManager;
	
	private static Logger log = LoggerFactory.getLogger(SwSupplierGroupController.class);
	
	/**
	 * 
	* @Title: queryJisoGroupPage 
	* @Description: 分页查询供应商分组名称和分组编码 
	* @param @param request
	* @param @param reponse
	* @param @param model
	* @param @return
	* @param @throws Exception    
	* @return PageJson 
	* @throws 
	* @author luoxq
	* @date   2018年10月11日 下午5:49:37
	 */
	@RequestMapping("queryJisoGroupPage")
	public @ResponseBody PageJson queryJisoGroupPage(HttpServletRequest request,
            HttpServletResponse reponse,
            @ModelAttribute("model") SwSupplierGroupModel model) throws Exception{
        DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
        
        HttpSession session = request.getSession();
        session.setAttribute(SessionKey.SW_SUPPLIER_GROUP_QUERYFILTER, model);
        
        PageList<SwSupplierGroupModel> pageList = (PageList<SwSupplierGroupModel>) swSupplierGroupManager.queryJisoGroupPage(model, p);
        return new PageJson(pageList);
	}
	
	/**
	 * 
	* @Title: queryJisoSupplierPage 
	* @Description: 分页查询供应商信息 
	* @param @param request
	* @param @param reponse
	* @param @param model
	* @param @return
	* @param @throws Exception    
	* @return PageJson 
	* @throws 
	* @author luoxq
	* @date   2018年10月12日 上午11:28:13
	 */
	@RequestMapping("queryJisoSupplierPage")
	public @ResponseBody PageJson queryJisoSupplierPage(HttpServletRequest request,
            HttpServletResponse reponse) throws Exception{
		String groupId = RequestUtil.getString(request, "groupId");
        DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
        SwSupplierGroupModel model = new SwSupplierGroupModel();
        model.setGroupId(groupId);
        PageList<SwSupplierGroupModel> pageList = (PageList<SwSupplierGroupModel>) swSupplierGroupManager.queryJisoSupplierPage(model, p);
        return new PageJson(pageList);
	}
	
	/**
	 * 
	* @Title: getSupplierListUnGroup 
	* @Description: 分页查询未分组供应商信息 
	* @param @param request
	* @param @param reponse
	* @param @return
	* @param @throws Exception    
	* @return PageJson 
	* @throws 
	* @author luoxq
	* @date   2018年10月12日 下午3:35:04
	 */
	@RequestMapping("getSupplierListUnGroup")
	public @ResponseBody PageJson getSupplierListUnGroup(HttpServletRequest request,
            HttpServletResponse reponse) throws Exception{
		String groupId = RequestUtil.getString(request, "groupId");
        DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
        SwSupplierGroupModel model = new SwSupplierGroupModel();
        model.setGroupId(groupId);
        PageList<SwSupplierGroupModel> pageList = (PageList<SwSupplierGroupModel>) swSupplierGroupManager.getSupplierListUnGroup(model, p);
        return new PageJson(pageList);
	}
	
	/**
	 * 
	* @Title: curdGetGroup 
	* @Description: 获取供应商分组信息 
	* @param @param request
	* @param @param response
	* @param @return
	* @param @throws Exception    
	* @return SwSupplierGroupModel 
	* @throws 
	* @author luoxq
	* @date   2018年10月11日 下午6:18:46
	 */
	@RequestMapping("curdGetGroup")
	public @ResponseBody SwSupplierGroupModel curdGetGroup(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		String groupId = RequestUtil.getString(request, "groupId");
		if(StringUtil.isEmpty(groupId)){
			return new SwSupplierGroupModel();
		}
		return swSupplierGroupManager.curdGetGroup(groupId);
	}
	
	/**
	 * 
	* @Title: save 
	* @Description: 保存修改或新增的供应商分组信息 
	* @param @param request
	* @param @param response
	* @param @param dpmAreaModel
	* @param @throws Exception    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月11日 下午6:24:49
	 */
	@RequestMapping("saveGroup")
	public void saveGroup(HttpServletRequest request,HttpServletResponse response,@RequestBody SwSupplierGroupModel swSupplierGroupModel) 
			throws Exception{
		String resultMsg = null;
		String groupId = swSupplierGroupModel.getGroupId();
		IUser user = ContextUtil.getCurrentUser();

		try {
			if(StringUtil.isEmpty(groupId)){
				SwSupplierGroupModel s= swSupplierGroupManager.getByGroupName(swSupplierGroupModel.getGroupName());
				if (s!=null) {
					resultMsg="分组名称已存在";
					writeResultMessage(response.getWriter(),resultMsg,ResultMessage.FAIL);
					return;
				}else {
					swSupplierGroupModel.setFactoryCode(user.getCurFactoryCode());
					swSupplierGroupModel.setCreationUser(user.getAccount()); //记录创建人
					swSupplierGroupManager.insertGroup(swSupplierGroupModel);
					resultMsg="添加成功";
				}
			}else{
				swSupplierGroupManager.updateAndLog(swSupplierGroupModel, RequestUtil.getIpAddr(request));
				swSupplierGroupModel.setLastModifiedUser(user.getAccount());//记录修改人
				resultMsg="更新成功";
			}
			writeResultMessage(response.getWriter(),resultMsg,ResultMessage.SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			resultMsg="操作失败";
			writeResultMessage(response.getWriter(),resultMsg,e.getMessage(),ResultMessage.FAIL);
		}
	}
	
	/**
	 * 
	* @Title: removeGroup 
	* @Description: 删除供应商分组信息 
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月12日 上午10:15:10
	 */
	@RequestMapping("removeGroup")
	public void removeGroup(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
			ResultMessage message=null;
			try {
				String[] groupIds = request.getParameterValues("groupIdArr");
				swSupplierGroupManager.removeAndLogByIds(groupIds, RequestUtil.getIpAddr(request));
				message = new ResultMessage(ResultMessage.SUCCESS, "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.toString());
				message = new ResultMessage(ResultMessage.FAIL, "删除失败");
			}
			writeResultMessage(response.getWriter(), message);
	}
	
	/**
	 * 
	* @Title: removeGroup 
	* @Description: 删除供应商信息 
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月12日 下午5:41:03
	 */
	@RequestMapping("removeSupplier")
	public void removeSupplier(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
			ResultMessage message=null;
			try {
			    String groupId = RequestUtil.getString(request, "groupId");
				String[] supplierNos = request.getParameterValues("supplierNoArr");
				swSupplierGroupManager.removeSupplierAndLogByIds(groupId,supplierNos, RequestUtil.getIpAddr(request));
				message = new ResultMessage(ResultMessage.SUCCESS, "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.toString());
				message = new ResultMessage(ResultMessage.FAIL, "删除失败");
			}
			writeResultMessage(response.getWriter(), message);
	}
	
	/**
	 * 
	* @Title: insertSupplier 
	* @Description: 新增供应商界面选择未分组信息，点击保存数据写入 MM_SW_SUP_GROUP_MEMBERS表中
	* @param @param request
	* @param @param response
	* @param @param swSupplierGroupModel
	* @param @throws Exception    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月12日 下午3:12:02
	 */
	@RequestMapping("insertSupplier")
	public void insertSupplier(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String resultMsg = null;
		String groupId = RequestUtil.getString(request, "groupId");
		String[] supplierNos = request.getParameterValues("supplierNoArr");
		IUser user = ContextUtil.getCurrentUser();
		SwSupplierGroupModel swSupplierGroupModel = new SwSupplierGroupModel();

		try {
			if(!StringUtil.isEmpty(groupId)){
				swSupplierGroupModel.setFactoryCode(user.getCurFactoryCode());
				swSupplierGroupModel.setCreationUser(user.getAccount()); //记录创建人
				swSupplierGroupModel.setGroupId(groupId);
				for (String supplierNo : supplierNos) {
					swSupplierGroupModel.setSupplierNo(supplierNo);
					swSupplierGroupManager.insertGroupId(swSupplierGroupModel);
				}
				resultMsg="添加成功";
			}else {
				resultMsg="未选择分组";
			}
			writeResultMessage(response.getWriter(),resultMsg,ResultMessage.SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			resultMsg="操作失败";
			writeResultMessage(response.getWriter(),resultMsg,e.getMessage(),ResultMessage.FAIL);
		}
	}
	
	/**
	 * 
	 * <p>Title: downloadSwSupplierGroupModel</p>  
	 * <p>Description: 供应分组信息导出</p>  
	 * @param request
	 * @param response  
	 * @authoer luoxq
	 * @time 2018年10月17日 下午3:15:30
	 */
	@RequestMapping("downloadSwSupplierGroupModel")
	public void downloadSwSupplierGroupModel(HttpServletRequest request,HttpServletResponse response){
		try {
		HttpSession session = request.getSession();
		String exportFileName = "供应商分组信息导出" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		SwSupplierGroupModel model = (SwSupplierGroupModel)session.getAttribute(SessionKey.SW_SUPPLIER_GROUP_QUERYFILTER);
		List<SwSupplierGroupModel> list =  swSupplierGroupManager.querySwSupplierGroupByKey(model);
		/**
		 * 如果查询记录超过10000条则报错
		 */
		if(0 == list.size()){
			ExcelUtil.exportNoDataError(request, response);
			return;
		}
		int sysMaxNum = SysPropertyUtil.getIntByAlias("EXCEL_EXPORT_MAX_SIZE", 10000); //获取系统所允许的最大导出数量
		if(list.size() > sysMaxNum){
			ExcelUtil.exportNumError(sysMaxNum, request, response);
			return;
		}
		
		String[] headers = {"分组名称","供应商代码", "供应商名称"};
		String[] columns = {"groupName","supplierNo", "supplierName"};
		int[] widths = {80,80, 300};
		ExcelUtil.exportExcel(ExcelUtil.EXCEL_XLSX, request, response, exportFileName, list, headers, widths, columns);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			ExcelUtil.exportException(e, request, response);
		}
	}
	
	/**
	 * 
	* @Title: importModel 
	* @Description: 文件导入 
	* @param @param file
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月13日 上午11:01:12
	 */
	@RequestMapping("importModel")
    public void importModel(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception{
        try {
            IUser user = ContextUtil.getCurrentUser();
            String uuid = null;
            HttpSession session = request.getSession();
            uuid = (String)session.getAttribute(SessionKey.MM_SW_SUPPLIER_GROUP_IMPORT_UUID);
            if(StringUtil.isNotEmpty(uuid)){
                swSupplierGroupManager.deleteImportTempDataByUUID(uuid);
            }else{
                uuid = UUID.randomUUID().toString().replaceAll("-", "");
            }
            session.setAttribute(SessionKey.MM_SW_SUPPLIER_GROUP_IMPORT_UUID, uuid);
            
            Map<String,Object> rtn = swSupplierGroupManager.importModel(file, uuid, RequestUtil.getIpAddr(request), user);
            if((Boolean)rtn.get("result")){
                writeResultMessage(response.getWriter(), JSONObject.fromObject(rtn).toString(), ResultMessage.SUCCESS);
            }else{
                writeResultMessage(response.getWriter(), JSONObject.fromObject(rtn).toString(), ResultMessage.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
            writeResultMessage(response.getWriter(), e.getMessage(), ResultMessage.FAIL);
        }
    }
	
	/**
     * 查询导入的临时供应商分组信息
     * @param request
     * @param reponse
     * @return
     * @throws Exception
     */
    @RequestMapping("curdlistImportTempJson")
    public @ResponseBody PageJson curdlistImportTempJson(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
        Map<String, String> paramMap = new HashMap<String, String>();
        HttpSession session = request.getSession();
        paramMap.put("uuid", (String)session.getAttribute(SessionKey.MM_SW_SUPPLIER_GROUP_IMPORT_UUID));
        QueryFilter queryFilter = getQueryFilter(request);
        Page page = queryFilter.getPage();
        PageList<SwSupplierGroupModelImport> pageList = (PageList<SwSupplierGroupModelImport>) swSupplierGroupManager.queryImportTempData(paramMap, page);
        return new PageJson(pageList);
    }
    
    /**
     * 将临时供应商分组维护数据导入正式表
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("isImport")
    public void isImport(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ResultMessage message = null;
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            HttpSession session = request.getSession();
            paramMap.put("uuid", (String)session.getAttribute(SessionKey.MM_SW_SUPPLIER_GROUP_IMPORT_UUID));
            paramMap.put("checkResult", ExcelUtil.EXCEL_IMPCKRESULT_SUCCESS);
            paramMap.put("factoryCode", ContextUtil.getCurrentUser().getCurFactoryCode());
            swSupplierGroupManager.insertImportData(paramMap);
            message = new ResultMessage(ResultMessage.SUCCESS, "执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
            message = new ResultMessage(ResultMessage.FAIL, "执行失败");
        }
        writeResultMessage(response.getWriter(), message);
    }

}
