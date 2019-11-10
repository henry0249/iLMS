package com.hanthink.pub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanthink.pub.manager.WelManager;
import com.hanthink.pub.model.WelModel;
import com.hotent.base.api.model.ResultMessage;
import com.hotent.base.core.web.GenericController;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageJson;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.sys.util.ContextUtil;

/**
 * @Desc : 主页查询控制器
 * @CreateOn: 2019年1月5日
 * @author : WY
 * @ChangeList Date Version Editor ChangeReasons
 */
@Controller
@RequestMapping("/pub/wel")
public class WelController extends GenericController {

    Logger logger = Logger.getLogger(WelController.class);

    @Resource
    WelManager welManager;

    /**
     * 分页查询包装提案信息
     * 
     * @param request
     * @param reponse
     * @param model
     * @return
     */
    @RequestMapping("curdPackageListJson")
    public @ResponseBody
    PageJson curdPackageListJson(HttpServletRequest request, HttpServletResponse reponse) {
        try {
            DefaultPage p = new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage()
                    .getPageSize()));
            WelModel model = new WelModel();
            model.setFactoryCode(ContextUtil.getCurrentUser().getCurFactoryCode());
            List<WelModel> pageList = (PageList<WelModel>) welManager.queryPackageForPage(model, p);
            return new PageJson(pageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 分页查询订单信息
     * 
     * @param request
     * @param reponse
     * @param model
     * @return
     */
    @RequestMapping("curdOrderListJson")
    public @ResponseBody
    PageJson curdOrderListJson(HttpServletRequest request, HttpServletResponse reponse) {
        try {
            DefaultPage p = new DefaultPage(new RowBounds(getQueryFilter(request).getPage().getStartIndex(), getQueryFilter(request).getPage()
                    .getPageSize()));
            WelModel model = new WelModel();
            model.setFactoryCode(ContextUtil.getCurrentUser().getCurFactoryCode());
            model.setSupplier(ContextUtil.getCurrentUser().getAccount());
            model.setUserType(ContextUtil.getCurrentUser().getUserType());
            List<WelModel> pageList = (PageList<WelModel>) welManager.queryOrderForPage(model, p);
            return new PageJson(pageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载工作时间
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("loadRolePanel")
    public void loadRolePanel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            // 根据用户查询首页面板的权限
            List<WelModel> models = welManager.loadRolePanel(ContextUtil.getCurrentUser().getAccount());
            rtn.put("panelModels", models);
            rtn.put("account", ContextUtil.getCurrentUser().getAccount());
            writeResultMessage(response.getWriter(), "", "", JSONObject.fromObject(rtn), ResultMessage.SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage());
            writeResultMessage(response.getWriter(), "数据查询失败", "", null, ResultMessage.FAIL);
        }
    }

}