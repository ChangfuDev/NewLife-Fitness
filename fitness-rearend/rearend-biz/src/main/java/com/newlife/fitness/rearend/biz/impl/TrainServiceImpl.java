package com.newlife.fitness.rearend.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.Train;
import com.newlife.fitness.rearend.biz.TrainService;
import com.newlife.fitness.rearend.dao.TrainDAO;

@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDAO trainDao;

	@Override
	public int getTraiCount(String tUserName, String tSex, Integer tAge, String tIsvip) {
		// TODO Auto-generated method stub
		return trainDao.getTraiCount(tUserName, tSex, tAge, tIsvip);
	}

	@Override
	public List<Train> getTrainByUserNameOrSexOrAgeOrIsVip(String tUserName, String tSex, Integer tAge, String tIsvip,
			Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return trainDao.selectFUserByUserNameOrSexOrAgeOrIsVip(tUserName, tSex, tAge, tIsvip, (page - 1) * limit,
				limit);
	}

	@Override
	public Train getTrainById(int id) {
		return trainDao.selectTrainById(id);
	}

	@Override
	public int modifTrain(Train train) {
		// TODO Auto-generated method stub
		return trainDao.updateTrain(train);
	}

	@Override
	public int saveTrain(Train train) {
		// TODO Auto-generated method stub
		return trainDao.insertTrain(train);
	}

	@Override
	public int delTrain(int id) {
		// TODO Auto-generated method stub
		return trainDao.delTrain(id);
	}

	@Override
	public int importTrain(List<Train> importCourses) {
		// TODO Auto-generated method stub
		return trainDao.importTrain(importCourses);
	}

}
