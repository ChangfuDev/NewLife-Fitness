package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.FUser;

public interface FUserDAO {

	
	/**
	 * 
	 * @Description (根据用户名或性别会员查询数据总条数)
	 * @param fUserName
	 * @param fSex
	 * @param fIsvip
	 * @return
	 */
	int selectCountByUserNameOrSex(@Param("fUserName") String fUserName, @Param("fSex") String fSex,
			@Param("fIsvip") String fIsvip);

	/**
	 * 
	 * @Description (根据用户名或性别或是否是会员查询分页查询数据)
	 * @param fUserName
	 * @param fSex
	 * @param fIsvip
	 * @param page
	 * @param limit
	 * @return
	 */
	List<FUser> selectFUserByUserNameOrSex(@Param("fUserName") String fUserName, @Param("fSex") String fSex,
			@Param("fIsvip") String fIsvip, @Param("page") Integer page, @Param("limit") Integer limit);
	
	/**
	 * 
	 * @Description (新增用户)
	 * @param record
	 * @return
	 */
	int insertFUser(FUser record);

	/**
	 * 
	 * @Description (根据id获取用户)
	 * @param id
	 * @return
	 */
	FUser selectFUserById(@Param("id")int id);

	/**
	 * 
	 * @Description (修改用户)
	 * @param user
	 * @return
	 */
	int updateUser(FUser user);
	
	/**
	 * 
	 * @Description (根据id删除用户)
	 * @param id
	 * @return
	 */
	int delUser(@Param("id")int id);

	/**
	 * 批量导入数据
	 * @param importCourses
	 * @return
	 */
	int importUser(List<FUser> importCourses);
	
	/**
	 * 插入数据的方法
	 * @param record
	 * @return
	 */
	int insert(FUser record);
	
}