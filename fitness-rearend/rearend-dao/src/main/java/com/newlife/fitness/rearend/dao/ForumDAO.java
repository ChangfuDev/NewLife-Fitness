package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ForumDAO {

	/**
	 * 根据用户id查询用户的论坛
	 * @param userId
	 * @return
	 */
	public List<Integer> selectForumIdByUserId(@Param("userId") int userId);

	/**
	 * 根据用户id删除相关论坛 userId
	 * 
	 * @param userId
	 * @return
	 */
	public int delForumByUserId(@Param("userId") int userId);

}