package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.Order;

/**
 * 
 * @ClassName: OrderBiz  
 * @Description: TODO
 * @author Unruly  
 * @date 2019年1月12日
 */
public interface OrderBiz {
	/**
	 * 获取订单列表的信息记录
	 * @return 
	 */
	List<Order> findOrderList(Integer pageNumber,Integer pageCount);
	
	/**
	 * 总数
	 * @return
	 */
	Integer findCount();
	
	/**
	 * 总数
	 * @return
	 */
	String findSumByPrice();
}
