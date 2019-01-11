package com.newlife.fitness.rearend.biz;

import com.newlife.fitness.entity.DUser;

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
}
