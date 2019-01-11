package com.newlife.fitness.rearend.biz;

import com.newlife.fitness.entity.FUser;

/**
 * @ClassName: FUserBiz  
 * @Description: 前台用户业务接口
 * @author Unruly  
 * @date 2019年1月4日
 */
public interface FUserBiz {

	boolean addFUser(FUser user) throws Exception;
}
