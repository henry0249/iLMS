package com.hanthink.jisi.dao;

import java.util.List;

import com.hanthink.jisi.model.JisiPartModel;
import com.hanthink.jisi.model.JisiVehQueueModel;
import com.hotent.base.db.api.Dao;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;

public interface JisiVehQueueDao extends Dao<String, JisiVehQueueModel>{

	/**
	 * 
	 * @Description: PA OFF队列查询分页查询
	 * @param @param model
	 * @param @param p
	 * @param @return   
	 * @return PageList<JisiVehQueueModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月9日 下午6:14:33
	 */
	PageList<JisiVehQueueModel> queryJisiVehQueueForPage(JisiVehQueueModel model, DefaultPage p);

	/**
	 * 
	 * @Description: 导出数据查询
	 * @param @param model
	 * @param @return   
	 * @return List<JisiVehQueueModel>  
	 * @throws  
	 * @author luoxq
	 * @date 2018年11月9日 下午6:21:33
	 */
	List<JisiVehQueueModel> queryJisiVehQueueByKey(JisiVehQueueModel model);

}
