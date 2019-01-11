package com.newlife.fitness.frontend.dao;


import com.newlife.fitness.entity.CourseVideo;

public interface CourseVideoDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(CourseVideo record);

    int insertSelective(CourseVideo record);

    CourseVideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseVideo record);

    int updateByPrimaryKey(CourseVideo record);
}