package com.hanthink.pub.dao;
import java.util.List;

import com.hanthink.pub.model.PubPrJobBusinessModel;
import com.hotent.base.db.api.Dao;
import com.hotent.base.db.mybatis.domain.DefaultPage;


/**
 * 
 * <pre> 
 * 描述：打印任务与业务关系配置 DAO接口
 * 构建组：x5-bpmx-platform
 * 作者:linzhuo
 * 邮箱:zhuo.lin@hotent.com
 * 日期:2018-09-10 10:39:09
 * 版权：汉思信息技术有限公司
 * </pre>
 */
public interface PubPrJobBusinessDao extends Dao<String, PubPrJobBusinessModel> {
	
	 /**
     * 分页查询打印任务与业务关系配置
     * @param model
     * @param p
     * @return
     */
    List<PubPrJobBusinessModel> queryPubPrJobBusinessForPage(PubPrJobBusinessModel model, DefaultPage p);

	/**
	 * 批量删除数据
	 * <p>return: void</p>  
	 * <p>Description: PubPrJobBusinessDao.java</p>  
	 * @author linzhuo  
	 * @date 2018年10月30日
	 * @version 1.0
	 * @throws Exception 
	 */
	void deleteByIds(String[] aryIds) throws Exception;
}
