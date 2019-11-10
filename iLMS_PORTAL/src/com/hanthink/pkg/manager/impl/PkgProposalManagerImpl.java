package com.hanthink.pkg.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanthink.base.manager.impl.AbstractManagerImpl;
import com.hanthink.base.model.DictVO;
import com.hanthink.base.model.TableColumnVO;
import com.hanthink.base.model.TableOpeLogVO;
import com.hanthink.pkg.dao.PkgProposalDao;
import com.hanthink.pkg.manager.PkgProposalManager;
import com.hanthink.pkg.model.PkgProposalModel;
import com.hanthink.util.constant.Constant;
import com.hotent.base.api.Page;
import com.hotent.base.db.api.Dao;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.org.api.model.IUser;
import com.hotent.sys.util.ContextUtil;

/**
* <p>Title: PkgProposalManagerImpl.java<／p>
* <p>Description: <／p>
* <p>Company: hanthink<／p>
* @author luoxq
* @date 2018年9月30日
*/
@Service("PkgProposalManager")
public class PkgProposalManagerImpl extends AbstractManagerImpl<String, PkgProposalModel> implements PkgProposalManager{

	@Resource
	private PkgProposalDao pkgProposalDao;
	/**
	 * 
	* @Title: queryPkgPartForPage 
	* @Description: 分页查询所有数据 
	* @param @param model
	* @param @param p
	* @param @return    
	* @return PageList<PkgPartModel> 
	* @throws 
	* @author luoxq
	* @date   2018年10月8日 上午10:45:58
	 */
	@Override
	public PageList<PkgProposalModel> queryPkgProposalForPage(PkgProposalModel model, DefaultPage p) {
		
		return pkgProposalDao.queryPkgProposalForPage(model,p);
	}

	@Override
	protected Dao<String, PkgProposalModel> getDao() {
		
		return pkgProposalDao;
	}

	/**
	 * 
	* @Title: getUnloadBoxCode 
	* @Description: 供应商包装提案界面获取箱code下拉框 
	* @param @return    
	* @return List<DictVO> 
	* @throws 
	* @author luoxq
	* @date   2018年10月8日 下午6:07:55
	 */
	@Override
	public List<DictVO> getUnloadBoxCode() {
		
		return pkgProposalDao.getUnloadBoxCode();
	}

	/**
	 * 
	* @Title: insertProposal 
	* @Description: 修改提案状态 
	* @param @param pkgProposalModel
	* @param @return    
	* @return String 
	* @throws 
	* @author luoxq
	* @date   2018年10月9日 下午2:35:48
	 */
	@Override
	public String updateProposal(PkgProposalModel pkgProposalModel) {
		String resultMsg = null;
		String entityId=pkgProposalModel.getId();
		PkgProposalModel p = pkgProposalDao.get(entityId);
		String proposalStatusStr = p.getProposalStatus();
		String proposalStatus = pkgProposalModel.getProposalStatus();
		if ("2".equals(proposalStatus) || "3".equals(proposalStatus) && !Constant.PKG_STATUS_CHECK.equals(proposalStatusStr)) {
			resultMsg = "请选择待审核状态信息进行审核";
			return resultMsg;
		}
		if ("4".equals(proposalStatus) || "5".equals(proposalStatus) && !Constant.PKG_STATUS_PASS.equals(proposalStatusStr)) {
			resultMsg = "请选择提案通过状态信息进行实物审核";
			return resultMsg;
		}
		
		//修改提案状态
		pkgProposalDao.updateProposal(pkgProposalModel);
		
		if ("2".equals(proposalStatus)) {
			resultMsg = "提案已审核通过";
			return resultMsg;
		}
		if ("3".equals(proposalStatus)) {
			resultMsg = "提案审核不通过";
			return resultMsg;
		}
		if ("4".equals(proposalStatus)) {
			resultMsg = "实物审核通过";
			return resultMsg;
		}
		if ("5".equals(proposalStatus)) {
			resultMsg = "实物审核不通过";
			return resultMsg;
		}
		return resultMsg;
	}

	/**
	 * 
	* @Title: insertNotTrolley 
	* @Description: 数据写入非台车包装信息表中MM_PKG_PRO_NOT_TROLLEY 
	* @param @param pkgProposalModel    
	* @return void 
	* @throws 
	* @author luoxq
	* @date   2018年10月9日 下午3:50:17
	 */
	@Override
	public void insertNotTrolley(PkgProposalModel pkgProposalModel) {
		pkgProposalDao.insertNotTrolley(pkgProposalModel);
	}

	/**
	 * 
	* @Title: queryPkgProposalByKey 
	* @Description: 查询需要导出的数据 
	* @param @param model
	* @param @return    
	* @return List<DpmInsModel> 
	* @throws 
	* @author luoxq
	* @date   2018年10月11日 上午10:59:58
	 */
	@Override
	public List<PkgProposalModel> queryPkgProposalByKey(PkgProposalModel model) {
		
		return pkgProposalDao.queryPkgProposalByKey(model);
	}

	/**
	 * 
	 * @Description: 包装管理查询界面，全车型查询
	 * @param @param list
	 * @param @return   
	 * @return PkgProposalModel  
	 * @throws  
	 * @author luoxq
	 * @date 2018年10月28日 下午5:33:17
	 */
	@Override
	public PageList<PkgProposalModel> queryListOfAllType(PkgProposalModel model,List<String> list, DefaultPage p) {
		
		return pkgProposalDao.queryListOfAllType(model,list, p);
	}

	/**
	 * 
	 * @Description: 包装管理查询界面，单车型查询
	 * @param @param list
	 * @param @return   
	 * @return PkgProposalModel  
	 * @throws  
	 * @author luoxq
	 * @date 2018年10月28日 下午8:38:06
	 */
	@Override
	public PageList<PkgProposalModel> queryListOfSigleType(PkgProposalModel model,  List<String> list , DefaultPage p) {
		
		return pkgProposalDao.queryListOfSigleType(model,list ,p);
	}

	/**
	 * 
	 * @param p 
	 * @Description: 包装管理查询界面，组合查询
	 * @param @param list
	 * @param @return   
	 * @return PkgProposalModel  
	 * @throws  
	 * @author luoxq
	 * @date 2018年10月28日 下午9:27:04
	 */
	@Override
	public PageList<PkgProposalModel> queryListOfComPackType(PkgProposalModel model, List<String> list , DefaultPage p) {
		
		return pkgProposalDao.queryListOfComPackType(model,list, p);
	}

	/**
	 * 
	 * @Description: 容器管理界面，箱子数量查询
	 * @param @param model
	 * @param @param p
	 * @param @return   
	 * @return PageList<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年10月29日 上午12:15:42
	 */
	@Override
	public PageList<PkgProposalModel> queryBoxNumForPage(PkgProposalModel model, DefaultPage p) {
		return pkgProposalDao.queryBoxNumForPage(model, p);
	}

	/**
	 * 
	 * @Description: 容器管理界面，托盘数量查询
	 * @param @param model
	 * @param @param p
	 * @param @return   
	 * @return PageList<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月2日 下午5:29:21
	 */
	@Override
	public PageList<PkgProposalModel> queryTrayNumForPage(PkgProposalModel model, DefaultPage p) {
		
		return pkgProposalDao.queryTrayNumForPage(model,p);
	}

	/**
	 * 
	 * @Description: 容器管理界面，箱子需求量维护
	 * @param @param model   
	 * @return void  
	 * @throws
	 * @author luoxq
	 * @date 2018年11月3日 上午10:36:52
	 */
	@Override
	public void updateBoxNeed(PkgProposalModel model) {
		pkgProposalDao.updateBoxNeed(model);
	}

	/**
	 * 
	 * @Description: 箱子纳入量更新
	 * @param @param model   
	 * @return void  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月3日 下午3:55:02
	 */
	@Override
	public void updateBoxProvide(PkgProposalModel model) {
		pkgProposalDao.updateBoxProvide(model);
		
	}

	/**
	 * 
	 * @Description: 托盘需求量管理
	 * @param @param model   
	 * @return void  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月3日 下午4:57:05
	 */
	@Override
	public void updateTrayNeed(PkgProposalModel model) {
		pkgProposalDao.updateTrayNeed(model);
	}

	/**
	 * 
	 * @Description: 托盘纳入量管理
	 * @param @param model   
	 * @return void  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月3日 下午4:57:23
	 */
	@Override
	public void updateTrayProvide(PkgProposalModel model) {
		pkgProposalDao.updateTrayProvide(model);
	}

	/**
	 * 
	 * @Description: 包装信息查询界面，车型弹窗
	 * @param @param model
	 * @param @return   
	 * @return List<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月4日 下午2:51:59
	 */
	@Override
	public List<PkgProposalModel> getCarType(PkgProposalModel model) {
		
		return pkgProposalDao.getCarType(model);
	}

	/**
	 * 
	 * @Description: 查询导出数据
	 * @param @param model
	 * @param @param carList
	 * @param @return   
	 * @return List<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月6日 上午10:13:49
	 */
	@Override
	public List<PkgProposalModel> queryListOfAllType(PkgProposalModel model, List<String> carList) {
		
		return pkgProposalDao.queryListOfAllType(model,carList);
	}

	/**
	 * 
	 * @Description: 查询导出数据
	 * @param @param model
	 * @param @param carList
	 * @param @return   
	 * @return List<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月6日 上午10:13:49
	 */
	@Override
	public List<PkgProposalModel> queryListOfSigleType(PkgProposalModel model, List<String> carList) {
		
		return pkgProposalDao.queryListOfSigleType(model,carList);
	}

	/**
	 * 
	 * @Description: 查询导出数据，组合查询导出
	 * @param @param model
	 * @param @param carList
	 * @param @return   
	 * @return List<PkgProposalModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月17日 下午2:44:00
	 */
	@Override
	public List<PkgProposalModel> queryListOfComPackType(PkgProposalModel model, List<String> carList) {
		
		return pkgProposalDao.queryListOfComPackType(model, carList);
	}

	/**
	 * 查询待发起提案的零件信息
	 * @param param
	 * @param page
	 * @return
	 * @author ZUOSL	
	 * @DATE	2018年11月23日 上午11:41:04
	 */
	@Override
	public PageList<Map<String, Object>> queryApplyPartDataList(Map<String, Object> param, Page page) {
		return pkgProposalDao.queryApplyPartDataList(param, page);
	}

	/**
	 * 发起 添加提案
	 * @param paramList
	 * @author ZUOSL	
	 * @DATE	2018年11月23日 下午12:45:49
	 */
	@Override
	public void addProposal(List<Map<String, String>> paramList) {
		
		for(Map<String, String> param : paramList){
			param.put("ID", queryDao.getSequenceNextVal("SEQ_MM_PKG_PROPOSAL")); //获取序列值
			param.put("STAY_NEW_STATUS_NEW", PkgProposalModel.STAY_NEW_STATUS_NEW); //新设标准值
		}
		
		//添加提案主信息
		pkgProposalDao.addProposal(paramList);
		
		//添加提案明细信息  为留用时获取该零件号最新的包装提案明细写入到新的提案明细，新设时只添加提案ID信息
		pkgProposalDao.addProposalDetail(paramList);
		
	}

	/**
	 * 供应商包装提案提交
	 * @param pkgModelList
	 * @author ZUOSL	
	 * @DATE	2018年11月26日 下午8:12:26
	 */
	@Override
	public void supPkgProposalSubmit(List<PkgProposalModel> pkgModelList) {
		
		//日志记录
		String[] columnValArr = new String[pkgModelList.size()];
		for(int i = 0; i < pkgModelList.size(); i ++){
			columnValArr[i] = pkgModelList.get(i).getId();
		}
		TableOpeLogVO logVO = new TableOpeLogVO();
		logVO.setOpeUserName(ContextUtil.getCurrentUser().getAccount());
		logVO.setOpeIp(""); 
		logVO.setFromName("供应商提案提交");
		logVO.setOpeType(TableOpeLogVO.OPE_TYPE_MODIFY);
		logVO.setTableName("MM_PKG_PROPOSAL");
		TableColumnVO pkColumnVO = new TableColumnVO();
		pkColumnVO.setColumnName("ID");
		pkColumnVO.setColumnValArr(columnValArr);
		this.tableDataLogDao.logOpeTableDataBatch(logVO, pkColumnVO);
		TableOpeLogVO logVO2 = new TableOpeLogVO();
		logVO2.setOpeUserName(ContextUtil.getCurrentUser().getAccount());
		logVO2.setOpeIp(""); 
		logVO2.setFromName("供应商提案提交");
		logVO2.setOpeType(TableOpeLogVO.OPE_TYPE_MODIFY);
		logVO2.setTableName("MM_PKG_PROPOSAL_DETAIL");
		TableColumnVO pkColumnVO2 = new TableColumnVO();
		pkColumnVO2.setColumnName("ID");
		pkColumnVO2.setColumnValArr(columnValArr);
		this.tableDataLogDao.logOpeTableDataBatch(logVO2, pkColumnVO2);
		
		//如果为组合包装做数据保存前的处理，
		PkgProposalModel p = pkgModelList.get(0);
		if(PkgProposalModel.IS_COM_PACK_YES.equals(p.getIsComPack())){
			
			//拼接组合包装零件备注
			StringBuffer sbf = new StringBuffer();
			for(int i = 0; i < pkgModelList.size(); i ++){
				if(i > 0){
					sbf.append(",");
				}
				sbf.append(pkgModelList.get(i).getPartNo());
			}
			
			String groupNo = queryDao.getSequenceNextVal("SEQ_MM_PKG_COMPACKGROUPNO");
			for(PkgProposalModel t : pkgModelList){
				t.setGroupNo(groupNo);
				t.setComPackRemark(sbf.toString());
				t.setProposalStatus(PkgProposalModel.PROPOSAL_STATUS_WCHECK); //提案状态修改为待审核
			}
		}else{
			for(PkgProposalModel t : pkgModelList){
				t.setGroupNo("");
				t.setComPackRemark("");
				t.setProposalStatus(PkgProposalModel.PROPOSAL_STATUS_WCHECK); //提案状态修改为待审核
			}
		}
		
		//更新包装提案主信息
		pkgProposalDao.updateSupSubmitPkgProposal(pkgModelList);
		
		//更新包装提案明细
		pkgProposalDao.updateSupSubmitPkgProposalDetail(pkgModelList);
		
	}

	/**
	 * 查询同组的组合提案信息
	 * @param proModel
	 * @return
	 * @author ZUOSL	
	 * @DATE	2018年11月29日 上午10:23:16
	 */
	@Override
	public List<PkgProposalModel> queryCombPackProposal(PkgProposalModel proModel) {
		return pkgProposalDao.queryCombPackProposal(proModel);
	}

	/**
	 * 签字提案文件上传，保存签字提案文件ID
	 * @param pkgModel
	 * @author ZUOSL	
	 * @DATE	2018年11月29日 下午3:19:13
	 */
	@Override
	public void uploadSignProFile(PkgProposalModel pkgModel) {
		pkgProposalDao.uploadSignProfile(pkgModel);
	}

	/**
	 * 
	 * @param pkgModelList
	 * @param user
	 * @author ZUOSL	
	 * @DATE	2018年11月30日 下午3:19:57
	 */
	@Override
	public void proposalCheckSubmit(List<PkgProposalModel> pkgModelList, IUser user) {
		//日志记录
		String[] columnValArr = new String[pkgModelList.size()];
		for(int i = 0; i < pkgModelList.size(); i ++){
			columnValArr[i] = pkgModelList.get(i).getId();
		}
		TableOpeLogVO logVO = new TableOpeLogVO();
		logVO.setOpeUserName(user.getAccount());
		logVO.setOpeIp(""); 
		logVO.setFromName("提案审核提交");
		logVO.setOpeType(TableOpeLogVO.OPE_TYPE_MODIFY);
		logVO.setTableName("MM_PKG_PROPOSAL");
		TableColumnVO pkColumnVO = new TableColumnVO();
		pkColumnVO.setColumnName("ID");
		pkColumnVO.setColumnValArr(columnValArr);
		this.tableDataLogDao.logOpeTableDataBatch(logVO, pkColumnVO);
		
		//更新包装提案状态
		for(PkgProposalModel model : pkgModelList){
			pkgProposalDao.updateProposalStatus(model);
		}
		
	}

	/**
	 * 根据零件号查询相关的包装提案数据信息
	 * @param param
	 * @param page
	 * @return
	 * @author ZUOSL	
	 * @DATE	2018年12月1日 上午10:12:48
	 */
	@Override
	public PageList<PkgProposalModel> queryProposalDataByPartNo(Map<String, Object> param, Page page) {
		return pkgProposalDao.queryProposalDataByPartNo(param, page);
	}

	/**
	 * @param map
	 * @author ZUOSL	
	 * @DATE	2018年12月1日 上午11:39:13
	 */
	@Override
	public void updteProposalEffDate(Map<String, String> map) {
		pkgProposalDao.updateProposalEffDate(map);
	}

	@Override
	public void proposalMaterialCheckSubmit(PkgProposalModel model, IUser user, String ipAddr) {
		
		//记录日志数据
		TableOpeLogVO logVO = new TableOpeLogVO();
		logVO.setOpeUserName(user.getAccount());
		logVO.setOpeIp(ipAddr); 
		logVO.setFromName("实物审核提交");
		logVO.setOpeType(TableOpeLogVO.OPE_TYPE_MODIFY);
		logVO.setTableName("MM_PKG_PROPOSAL");
		TableColumnVO pkColumnVO = new TableColumnVO();
		pkColumnVO.setColumnName("ID");
		pkColumnVO.setColumnVal(model.getId());
		this.tableDataLogDao.logOpeTableData(logVO, pkColumnVO);
		
		//更新提案状态
		pkgProposalDao.updateProposalStatus(model);
		
		//如果审核通过 更新生失效日期
		if(PkgProposalModel.PROPOSAL_STATUS_MCHECK_YES.equals(model.getProposalStatus())){
			Map<String, String> map = new HashMap<String, String>();
			map.put("EFF_START", model.getEffStart());
			map.put("EFF_END", model.getEffEnd());
			map.put("ID", model.getId());
			pkgProposalDao.updateProposalEffDate(map);
			
			//如果实物审核通过，则把提案信息写到箱子数量维护表中
			pkgProposalDao.insertBoxQty(model);
		}
		
	}

	@Override
	public List<PkgProposalModel> getProposalStatus(Map<String, Object> map) {
		
		return pkgProposalDao.getProposalStatus(map);
	}

	/**
	 * 
	 * @Description: 留用状态零件根据零件号获取上个零件的包装信息
	 * @param @param map
	 * @param @return   
	 * @return PkgProposalModel  
	 * @throws  
	 * @author luoxq
	 * @date 2019年1月17日 下午9:13:54
	 */
	@Override
	public PkgProposalModel getProposalByStayPart(Map<String, Object> map) {
		
		return pkgProposalDao.getProposalByStayPart(map);
	}

}
