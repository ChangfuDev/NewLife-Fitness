package com.newlife.fitness.rearend.dao;


import com.newlife.fitness.entity.Train;

public interface TrainDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);
}