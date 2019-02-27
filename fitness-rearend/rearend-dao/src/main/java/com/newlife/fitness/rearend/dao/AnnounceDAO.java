package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.Announce;

public interface AnnounceDAO {
	/**
	 * 查找所有的方法
	 * @return 通知的列表内容
	 */
	List<Announce> selectAll(@Param("pageNumber") Integer pageNumber,@Param("pageCount") Integer pageCount);
	
	/**
	 * 查找前三条信息
	 * @return 
	 */
	List<Announce> selectByLimit3();
	
	/**
	 * 插入一条信息
	 * @param announce
	 * @return 返回插入信息的对象
	 */
	int insertInfo(Announce announce);
	
	
	/**
	 * 查询总数
	 * @return
	 */
	Integer selectCount();
}
