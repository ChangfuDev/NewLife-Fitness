package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.DUser;

/**
 * 
 * @ClassName: DUserBiz  
 * @Description: TODO
 * @author Unruly  
 * @date 2019年1月12日
 */
public interface DUserBiz {
	
	/**
	 * 查询服务，根据传入的User已有的属性进行动态判断
	 * @param user DUser对象
	 * @return DUser实体
	 * @throws Exception
	 */
	DUser getLoginDUser(DUser user) throws Exception;
	
	/**
	 * 添加用户的服务
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int addDUser(DUser user) throws Exception;
	
	/**
	 * 动态修改用户的方法，根据参数值进行修改。id为必须的
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean modifyDUser(DUser user) throws Exception;
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	DUser getFUser(int id);

	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	int delDUser(Integer id);
	
	/**
	 * 查询所有用户
	 * @param limit 
	 * @param page 
	 * @param userRole 
	 * @param dUserName 
	 * @return
	 */
	List<DUser> getDUsers(String dUserName, String userRole, Integer page, Integer limit);
	
	
	/**
	 * 获取用户总数
	 * @param dUserName
	 * @param userRole
	 * @return
	 */
	int getCount(String dUserName,String userRole);
}
