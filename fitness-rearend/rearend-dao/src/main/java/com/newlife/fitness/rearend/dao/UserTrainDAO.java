package com.newlife.fitness.rearend.dao;

import org.apache.ibatis.annotations.Param;


public interface UserTrainDAO {

	/**
	 * 根据用户id删除教练预约信息
	 * @param userId
	 * @return
	 */
	public int delUserTrainByUserId(@Param("userId")int userId);
}