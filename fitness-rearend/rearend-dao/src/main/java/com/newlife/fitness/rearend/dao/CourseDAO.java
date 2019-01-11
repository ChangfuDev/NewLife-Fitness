package com.newlife.fitness.rearend.dao;



import com.newlife.fitness.entity.Course;

public interface CourseDAO {


    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}