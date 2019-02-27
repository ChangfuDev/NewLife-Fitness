package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.Train;

public interface TrainDAO {

	/**
	 * 根据条件查询数据总条数
	 * 
	 * @param tUserName
	 * @param tSex
	 * @param tAge
	 * @param tIsvip
	 * @return
	 */
	int getTraiCount(@Param("tUserName") String tUserName, @Param("tSex") String tSex, @Param("tAge") Integer tAge,
			@Param("tIsvip") String tIsvip);

	/**
	 * 根据条件分页查询数据
	 * @param tUserName
	 * @param tSex
	 * @param tAge
	 * @param tIsvip
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Train> selectFUserByUserNameOrSexOrAgeOrIsVip(@Param("tUserName") String tUserName,@Param("tSex") String tSex,@Param("tAge") Integer tAge,@Param("tIsvip") String tIsvip, @Param("page") Integer page,
			@Param("limit") Integer limit);

	/**
	 * 根据id获取数据
	 * @param id
	 * @return
	 */
	Train selectTrainById(@Param("id") int id);

	/**
	 * 修改信息
	 * @param train
	 * @return
	 */
	int updateTrain(Train train);

	/**
	 * 新增信息
	 * @param train
	 * @return
	 */
	int insertTrain(Train train);

	/**
	 * 根据id删除信息
	 * @param id
	 * @return
	 */
	int delTrain(@Param("id") int id);

	/**
	 * 批量插入数据
	 * @param importCourses
	 * @return
	 */
	int importTrain(List<Train> importCourses);
}