package com.newlife.fitness.rearend.dao;

import com.newlife.fitness.entity.Comments;
public interface CommentsDAO {


    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}