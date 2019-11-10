package com.hanthink.jit.manager;

import java.util.List;

import com.hanthink.jit.model.JitLabelModel;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.base.manager.api.Manager;

/**
 * @ClassName: JitLabelManager
 * @Description: 零件标签查询
 * @author dtp
 * @date 2018年9月29日
 */
public interface JitLabelManager extends Manager<String, JitLabelModel> {

	/**
	 * @Description: 零件标签查询
	 * @param: @param model
	 * @param: @param page
	 * @param: @return    
	 * @return: PageList<JitLabelModel>   
	 * @author: dtp
	 * @date: 2018年9月29日
	 */
	PageList<JitLabelModel> queryJitLabelPage(JitLabelModel model, DefaultPage page);

	/**
	 * @Description: 零件标签查询导出 
	 * @param: @param model
	 * @param: @return    
	 * @return: List<JitLabelModel>   
	 * @author: dtp
	 * @date: 2018年9月29日
	 */
	List<JitLabelModel> queryJitLabelList(JitLabelModel model);

	/**
	 * @Description: 获取标签(标签打印) 
	 * @param: @param model
	 * @param: @return    
	 * @return: JitLabelModel   
	 * @author: dtp
	 * @date: 2018年10月4日
	 */
	JitLabelModel queryJitLabel(JitLabelModel model);

	/**
	 * @Description: 更新打印信息
	 * @param: @param list_printInfo    
	 * @return: void   
	 * @author: dtp
	 * @param list 
	 * @date: 2018年12月26日
	 */
	void updateJitLabelPrintInfo(List<JitLabelModel> list_printInfo, List<JitLabelModel> list);

}
