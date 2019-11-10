package com.hanthink.inv.dao;

import java.util.List;
import java.util.Map;

import com.hanthink.inv.model.PartMainTenanance;
import com.hotent.base.db.api.Dao;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;

public interface PartMaintenanceManagerDao extends Dao<String, PartMainTenanance>{
	

	/**
	 * 分页查询
	 *
	 * @param model
	 * @param p
	 * @return
	 * 李兴辉
	 */
	public PageList<PartMainTenanance> querypartMaintenanceForPage(
			PartMainTenanance model, DefaultPage p);
	
	/**
	 * 查询属地零件作为导出数据
	 *
	 * @param model
	 * @return
	 * 李兴辉
	 */
	public List<PartMainTenanance> queryexportList(PartMainTenanance model);

	/**
	 * 查询导入的临时数据
	 * @param model
	 * @return
	 * 李兴辉
	 */
	public List<PartMainTenanance> queryPartMaintenanceImport(PartMainTenanance model);

	/**
	 * excel数据导入到临时表
	 *
	 * @param file
	 * @return
	 * 李兴辉
	 */
	public void importPartMaintenanceTemp(List<PartMainTenanance> importList);

	/**
	 * excel数据导入到临时表
	 *
	 * @param file
	 * @return
	 * 李兴辉
	 */
	public void checkImportData(Map<String, String> ckParamMap);

	/**
	 *导入确认
	 *
	 * @return
	 * 李兴辉
	 */
	public void PartMaintenanceImportData(Map<String, String> ckParamMap);

	/**
	 * 导入的临时数据查询
	 *
	 * @param model
	 * @param page
	 * @return
	 * 李兴辉
	 */
	public PageList<PartMainTenanance> queryPartMaintenanceTemp(PartMainTenanance model, DefaultPage page);

	/**
	 * 导入的临时数据用于导出
	 *
	 * @param model
	 * @return
	 * 李兴辉
	 */
	public List<PartMainTenanance> queryPartMaintenanceTemp(PartMainTenanance model);

	/**
	 * 获取仓库代码
	 * @param m
	 * @return
	 * Lxh
	 */
	public List<PartMainTenanance> getWarCode(PartMainTenanance m);
	

	/**
	 * 临时数据删除
	 * @return
	 * Lxh
	 */
	public int removePartMaintenanceTemp();

	/**
	 * 查询验证不通过的数据是否存在
	 * @param m 
	 * @return
	 * Lxh
	 */
	public int queryImportFailCount(PartMainTenanance m);

	/**
	 * 零件数据维护查询货架标签打印信息
	 * @Description:   
	 * @param: @param model
	 * @param: @return    
	 * @return: PartMainTenanance   
	 * @author: dtp
	 * @date: 2019年1月19日
	 */
	public PartMainTenanance queryInvShelfPrintInfo(PartMainTenanance model);

}
