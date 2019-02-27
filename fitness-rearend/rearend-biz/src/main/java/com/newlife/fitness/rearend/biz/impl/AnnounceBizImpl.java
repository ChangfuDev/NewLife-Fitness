package com.newlife.fitness.rearend.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.Announce;
import com.newlife.fitness.rearend.biz.AnnounceBiz;
import com.newlife.fitness.rearend.dao.AnnounceDAO;

@Service
public class AnnounceBizImpl implements AnnounceBiz{
	
	@Resource
	private AnnounceDAO announceDao;
	
	@Override
	public List<Announce> findAllInfo(Integer pageNumber,Integer pageCount) {
		return announceDao.selectAll((pageNumber-1)*pageCount,pageCount);
	}
	
	@Override
	public List<Announce> findByLimit3() {
		return announceDao.selectByLimit3();
	}

	@Override
	public boolean addOneInfo(Announce anounce) {
		return announceDao.insertInfo(anounce) == 1;
	}

	@Override
	public Integer findInfoCount() {
		return announceDao.selectCount();
	}

}
