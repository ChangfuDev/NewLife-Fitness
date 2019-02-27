package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.Order;

public interface OrderDAO {
	
	/**
	 * 查询分页所有信息的方法，根据日期排序 desc
	 * @return
	 */
	List<Order> selectAllInfo(@Param("pageNumber") Integer pageNumber,
							  @Param("pageCount") Integer pageCount);
	
	/**
	 * 查询总数
	 * @return
	 */
	Integer selectCount();
	
	/**
	 * 查询总价
	 * @return
	 */
	String selectCountByPrice();
}
