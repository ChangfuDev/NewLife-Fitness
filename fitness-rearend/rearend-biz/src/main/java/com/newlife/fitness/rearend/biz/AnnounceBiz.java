package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.Announce;

/**
 * @ClassName: AnnounceBiz  
 * @Description: TODO
 * @author Unruly  
 * @date 2019年1月12日
 */
public interface AnnounceBiz {

	/**
	 * 查找所有的信息
	 * @return
	 */
	List<Announce> findAllInfo(Integer pageNumber,Integer pageCount);
	
	/**
	 * 查找前三条的通知
	 * @return
	 */
	List<Announce> findByLimit3();
	
	/**
	 * 添加一条通知信息
	 * @return
	 */
	boolean addOneInfo(Announce anounce);
	
	/**
	 * 查找分页总数
	 * @return
	 */
	Integer findInfoCount();
}
