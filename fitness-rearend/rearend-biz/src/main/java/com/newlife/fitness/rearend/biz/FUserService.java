package com.newlife.fitness.rearend.biz;

import java.util.List;


import com.newlife.fitness.entity.FUser;

public interface FUserService {

    /**
     * 
     * @Description (通过用户名性别获取数据条数)
     * @param fUserName
     * @param fSex
     * @param fIsvip
     * @return
     */
	public int getCountByUserNameOrSex(String fUserName, String fSex, String fIsvip);

	/**
	 * 
	 * @Description (根据户名性别会员分页获取用户)
	 * @param fUserName
	 * @param fSex
	 * @param fIsvip
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<FUser> getFUserByUserNameOrSex(String fUserName, String fSex, String fIsvip, Integer page,
			Integer limit);

	/**
	 * 
	 * @Description (保存用户)
	 * @param user
	 * @return 
	 */
	public int saveFUser(FUser user);

	/**
	 * 
	 * @Description (根据id获取用户)
	 * @param user
	 * @return 
	 */
	public FUser getFUser(int id);

	/**
	 * 
	 * @Description (修改客戶)
	 * @param user
	 * @return 
	 */
	public int modifyUser(FUser user);

	/**
	 * 
	 * @Description (删除用户)
	 * @param id
	 * @return 
	 */
	public int delUser(int id);

	/**
	 * 批量导入用户
	 * @param importCourses
	 * @return
	 */
	public int importUser(List<FUser> importCourses);

}
