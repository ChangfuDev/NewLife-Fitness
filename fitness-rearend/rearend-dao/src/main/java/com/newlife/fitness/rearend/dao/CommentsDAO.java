package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommentsDAO {

	
	/**
	 * 根据用户id删除评论
	 * @param userId
	 * @return
	 */
	public int delCommentsByUserId(@Param("userId") int userId);
	
	/**
	 * 根据论坛id删除评论
	 * @param ForumId
	 * @return
	 */
	public int delCommentsByForumId(List<Integer> ForumId);

}