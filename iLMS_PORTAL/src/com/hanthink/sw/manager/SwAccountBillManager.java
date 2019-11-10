package com.hanthink.sw.manager;

import java.util.List;

import com.hanthink.sw.model.SwAccountBillModel;
import com.hanthink.sw.model.SwDemandForecastModel;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.base.manager.api.Manager;
/**
 * 
* <p>Title: SwAccountBillManager</p>  
* <p>Description: 发票对账管理manager</p> 
* <p>Company: hanthink</p>
* @author luoxq  
* @date 2018年10月22日 下午4:36:10
 */
public interface SwAccountBillManager extends Manager<String, SwAccountBillModel>{

	/**
	 * 
	 * <p>Title: queryJisoAccountBillPage</p>  
	 * <p>Description: 发票对账管理，分页查询功能</p>  
	 * @param model
	 * @param p
	 * @return  
	 * @authoer luoxq
	 * @time 2018年10月22日 下午4:38:38
	 */
	PageList<SwAccountBillModel> queryJisoAccountBillPage(SwAccountBillModel model, DefaultPage p);

	
	/**
	 * 
	 * <p>Title: queryJisoAccountBillDetailPage</p>  
	 * <p>Description: 发票对账管理，明细查看功能</p>  
	 * @param model
	 * @param p
	 * @return  
	 * @authoer luoxq
	 * @time 2018年10月22日 下午5:04:59
	 */
	PageList<SwAccountBillModel> queryJisoAccountBillDetailPage(SwAccountBillModel model, DefaultPage p);

	/**
	 * 
	 * <p>Title: billFeedback</p>  
	 * <p>Description: 发票对账管理，反馈功能</p>  
	 * @param model  
	 * @authoer luoxq
	 * @time 2018年10月22日 下午5:41:44
	 */
	void billFeedback(SwAccountBillModel model);

	/**
	 * 
	 * <p>Title: querySwAccountBillByKey</p>  
	 * <p>Description: 发票对账管理界面，导出功能</p>  
	 * @param model
	 * @return  
	 * @authoer luoxq
	 * @time 2018年10月22日 下午6:06:03
	 */
	List<SwAccountBillModel> querySwAccountBillByKey(SwAccountBillModel model);

	/**
	 * 
	 * <p>Title: querySwAccountDetailBillByKey</p>  
	 * <p>Description: 发票对账管理明细查看，导出功能</p>  
	 * @param model
	 * @return  
	 * @authoer luoxq
	 * @time 2018年10月22日 下午6:12:25
	 */
	List<SwAccountBillModel> querySwAccountDetailBillByKey(SwAccountBillModel model);

	/**
	 * 
	 * @Description: 根据对账单号，发票号，发票代码判断发票是否已存在
	 * @param @param model
	 * @param @return   
	 * @return Boolean  
	 * @throws  
	 * @author luoxq
	 * @date 2018年12月19日 下午9:27:07
	 */
	Boolean isExists(SwAccountBillModel model);

	/**
	 * 
	 * @Description: 查看发票反馈情况
	 * @param @param model
	 * @param @param p
	 * @param @return   
	 * @return PageList<SwAccountBillModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2019年1月3日 下午2:01:27
	 */
	PageList<SwAccountBillModel> queryJisoAccountInvoicePage(SwAccountBillModel model, DefaultPage p);

	/**
	 * 
	 * @Description: 发票反馈提交后修改主表中提交标识
	 * @param @param billNoArr
	 * @param @param submitStatusYes   
	 * @return void  
	 * @throws  
	 * @author luoxq
	 * @date 2019年1月3日 下午4:10:11
	 */
	void updateSubmitStatus(String[] billNoArr, String submitStatusYes);


	/**
	 * 
	 * @Description: 发票对账查看（物流）
	 * @param @param model
	 * @param @param p
	 * @param @return   
	 * @return PageList<SwAccountBillModel>  
	 * @throws  
	 * @author zengfanzhuo
	 * @date 2019年6月19日 下午2:11:31
	 */
	PageList<SwAccountBillModel> queryJisoAccountBillSearchPage(SwAccountBillModel model, DefaultPage p);

	/**
	 * 
	 * @Description: 发票对账导出（物流）
	 * @param @param model
	 * @param @return   
	 * @return List<SwAccountBillModel>  
	 * @throws  
	 * @author zengfanzhuo
	 * @date 2019年6月19日 下午2:14:23
	 */
	List<SwAccountBillModel> querySwAccountBillSearchByKey(SwAccountBillModel model);

	/**
	 * 
	 * @Description: 导出反馈的发票信息
	 * @param @param model
	 * @param @return   
	 * @return List<SwAccountBillModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2019年6月20日 下午3:15:11
	 */
	List<SwAccountBillModel> downloadSwAccountBillInvoiceModel(SwAccountBillModel model);

}
