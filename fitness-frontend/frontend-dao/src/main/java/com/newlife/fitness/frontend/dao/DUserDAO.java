package com.newlife.fitness.frontend.dao;


import com.newlife.fitness.entity.DUser;

public interface DUserDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(DUser record);

    int insertSelective(DUser record);

    DUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DUser record);

    int updateByPrimaryKey(DUser record);
}