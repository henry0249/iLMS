package com.hotent.org.persistence.manager;

import java.util.List;

import com.hotent.base.api.Page;
import com.hotent.base.db.mybatis.domain.PageList;
import com.hotent.base.manager.api.Manager;
import com.hotent.org.persistence.model.UserRole;

/**
 * 
 * <pre> 
 * 描述：用户角色管理 处理接口
 * 构建组：x5-bpmx-platform
 * 作者:ray
 * 邮箱:zhangyg@jee-soft.cn
 * 日期:2016-06-30 10:28:34
 * 版权：广州宏天软件有限公司
 * </pre>
 */
public interface UserRoleManager extends Manager<String, UserRole>{
	
	/**
	 * 根据用户和角色id 查询 关联关系。
	 * @param roleId
	 * @param userId
	 * @return
	 */
	UserRole getByRoleIdUserId(String roleId,String userId);
	
	/**
	 * 获取用户的角色。
	 * @param userId
	 * @return
	 */
	List<UserRole> getListByUserId(String userId);
	
	/**
	 * 根据角色ID查询关联的用户。
	 * @param roleId
	 * @return
	 */
	List<UserRole> getListByRoleId(String roleId);
	
	/**
	 * 根据角色别名查询关联的用户。
	 * @param roleId
	 * @return
	 */
	List<UserRole> getListByAlias(String alias);
	
	/**
	 * 根据用户ID查询该用户未添加的所有菜单角色信息
	 * @param model
	 * @param p
	 * @return
	 * @author ZUOSL	
	 * @DATE	2019年1月18日 上午11:11:37
	 */
	PageList<UserRole> queryAddUserMenuRoleByUserId(UserRole model, Page p);

	/**
	 * 根据用户ID查询该用户未添加且在当前登录用户有的数据角色
	 * @param model
	 * @param p
	 * @return
	 * @author ZUOSL	
	 * @DATE	2019年1月18日 上午11:12:18
	 */
	PageList<UserRole> queryCurUserAddUserMenuRoleByUserId(UserRole model, Page p);
}
