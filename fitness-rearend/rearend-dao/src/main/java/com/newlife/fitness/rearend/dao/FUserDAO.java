package com.newlife.fitness.rearend.dao;



import com.newlife.fitness.entity.FUser;

public interface FUserDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(FUser record);

    int insertSelective(FUser record);

    FUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FUser record);

    int updateByPrimaryKey(FUser record);
}