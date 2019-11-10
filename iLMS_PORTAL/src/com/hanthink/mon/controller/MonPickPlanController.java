package com.hanthink.mon.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanthink.mon.manager.MonPickPlanManager;
import com.hanthink.mon.model.MonPickPlanModel;
import com.hotent.base.core.web.GenericController;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageJson;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.sys.util.ContextUtil;


@Controller
@RequestMapping("/mon/pickPlan")
public class MonPickPlanController extends GenericController{

	@Resource
	private MonPickPlanManager manager;
	
	private static Logger log = LoggerFactory.getLogger(MonPickPlanController.class);


	@RequestMapping("queryReceiptPage")
	public @ResponseBody PageJson queryReceiptPage(HttpServletRequest request,
            HttpServletResponse reponse,
            @ModelAttribute("model") MonPickPlanModel model) throws Exception{
        DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
        PageList<MonPickPlanModel> pageList = (PageList<MonPickPlanModel>) manager.queryReceiptPage(model, p);
        return new PageJson(pageList);
	}
	
	
	@RequestMapping("queryReceiptDetailPage")
	public @ResponseBody PageJson queryReceiptDetailPage(HttpServletRequest request,
            HttpServletResponse reponse,
            @ModelAttribute("model") MonPickPlanModel model) throws Exception{
		DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
		String queryString = request.getQueryString();
		String decode = java.net.URLDecoder.decode(queryString);
		String[] split = decode.split("=");
		model.setSupplierNo(split[1].trim());
		model.setFactoryCode(ContextUtil.getCurrentUser().getCurFactoryCode());
        PageList<MonPickPlanModel> pageList = (PageList<MonPickPlanModel>) manager.queryReceiptDetailPage(model, p);
        return new PageJson(pageList);
	}
	
	@RequestMapping("queryOutPage")
	public @ResponseBody PageJson queryOutPage(HttpServletRequest request,
            HttpServletResponse reponse,
            @ModelAttribute("model") MonPickPlanModel model) throws Exception{
        DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
        PageList<MonPickPlanModel> pageList = (PageList<MonPickPlanModel>) manager.queryOutPage(model, p);
        return new PageJson(pageList);
	}
	
	
	@RequestMapping("queryOutDetailPage")
	public @ResponseBody PageJson queryOutDetailPage(HttpServletRequest request,
            HttpServletResponse reponse,
            @ModelAttribute("model") MonPickPlanModel model) throws Exception{
		DefaultPage p=new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage().getPageSize()));
		String parameter = request.getParameter("supplierNo");
		String queryString = request.getQueryString();
		String decode = java.net.URLDecoder.decode(queryString);
		String[] split = decode.split("=");
		model.setSupplierNo(split[1].trim());
		model.setFactoryCode(ContextUtil.getCurrentUser().getCurFactoryCode());
        PageList<MonPickPlanModel> pageList = (PageList<MonPickPlanModel>) manager.queryOutDetailPage(model, p);
        return new PageJson(pageList);
	}
	
	
}
