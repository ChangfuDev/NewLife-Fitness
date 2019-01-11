package com.newlife.fitness.frontend.dao;


import com.newlife.fitness.entity.Forum;

public interface ForumDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(Forum record);

    int insertSelective(Forum record);

    Forum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Forum record);

    int updateByPrimaryKey(Forum record);
}