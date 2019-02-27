package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.Train;

public interface TrainService {

	/**
	 * 根据条件获取相关数据总条数
	 * @param tUserName 教练名称
	 * @param tSex 性别
	 * @param tIsvip 是否被预约
	 * @param tAge年龄
	 * @return
	 */
	int getTraiCount(String tUserName, String tSex, Integer tAge, String tIsvip);
	
	/**
	 * 根据条件分页获取教练信息
	 * @param tUserName
	 * @param tSex
	 * @param tAge
	 * @param tIsvip
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Train> getTrainByUserNameOrSexOrAgeOrIsVip(String tUserName, String tSex, Integer tAge, String tIsvip,
			Integer page, Integer limit);
	
	/**
	 * 根据id获取教练
	 * @param id
	 * @return
	 */
	Train getTrainById(int id);

	/**
	 * 修改教练信息
	 * @param train
	 * @return
	 */
	int modifTrain(Train train);

	/**
	 * 新增教练
	 * @param train
	 * @return
	 */
	int saveTrain(Train train);

	/**
	 * 删除教练
	 * @param id
	 * @return
	 */
	int delTrain(int id);

	/**
	 * 批量插入
	 * @param importCourses
	 * @return
	 */
	int importTrain(List<Train> importCourses);
	
}
