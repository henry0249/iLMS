package com.hanthink.jit.dao;
import java.util.List;

import com.hanthink.jit.model.JitPkgReqModel;
import com.hotent.base.db.api.Dao;
import com.hotent.base.db.mybatis.domain.DefaultPage;


/**
 * 
 * <pre> 
 * 描述：拉动包装明细查询DAO接口
 * 构建组：x5-bpmx-platform
 * 作者:linzhuo
 * 邮箱:zhuo.lin@hotent.com
 * 日期:2018-09-10 10:39:09
 * 版权：汉思信息技术有限公司
 * </pre>
 */
public interface JitPkgReqDao extends Dao<String, JitPkgReqModel> {
	/**
	 * 分页查询
	 * <p>return: PageList<JitPkgReqModel></p>  
	 * <p>Description: JitPkgReqDao.java</p>  
	 * @author linzhuo  
	 * @date 2018年9月28日
	 * @version 1.0
	 */
	List<JitPkgReqModel> queryJitPkgReqForPage(JitPkgReqModel model, DefaultPage p);

	/**
	 * 导出查询的方法
	 * <p>return: List<JitPkgReqModel></p>  
	 * <p>Description: JitPkgReqDao.java</p>  
	 * @author linzhuo  
	 * @date 2018年9月30日
	 * @version 1.0
	 */
	List<JitPkgReqModel> queryJitPkgReqByKey(JitPkgReqModel model);
}
