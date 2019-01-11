package com.newlife.fitness.frontend.dao;

import com.newlife.fitness.entity.UserCourse;

public interface UserCourseDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}