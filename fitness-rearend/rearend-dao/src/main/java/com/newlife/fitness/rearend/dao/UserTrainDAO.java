package com.newlife.fitness.rearend.dao;


import com.newlife.fitness.entity.UserTrain;

public interface UserTrainDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(UserTrain record);

    int insertSelective(UserTrain record);

    UserTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTrain record);

    int updateByPrimaryKey(UserTrain record);
}