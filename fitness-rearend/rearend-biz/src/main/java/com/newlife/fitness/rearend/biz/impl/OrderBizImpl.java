package com.newlife.fitness.rearend.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.Order;
import com.newlife.fitness.rearend.biz.OrderBiz;
import com.newlife.fitness.rearend.dao.OrderDAO;

@Service
public class OrderBizImpl implements OrderBiz{
	
	@Resource
	private OrderDAO orderDao;
	

	@Override
	public List<Order> findOrderList(Integer pageNumber, Integer pageCount) {
		return orderDao.selectAllInfo((pageNumber-1)*pageCount,pageCount);
	}


	@Override
	public Integer findCount() {
		return orderDao.selectCount();
	}


	@Override
	public String findSumByPrice() {
		return orderDao.selectCountByPrice();
	}

}
