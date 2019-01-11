package com.newlife.fitness.rearend.dao;


import com.newlife.fitness.entity.DUser;

public interface DUserDAO {

	/**
	 * 根据主键进行删除的方法
	 * @param id 主键id
	 * @return 受影响行数
	 */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 添加用户的方法
     * @param record
     * @return
     */
    int insert(DUser record);
    
    /**
     * 动态更新用户的方法
     * @param record
     * @return
     */
    int update(DUser record);

    /**
     * 根据用户主键查询的方法
     * @param id
     * @return
     */
    DUser selectByPrimaryKey(Integer id);
    
    /**
     * 根据实体条件进行查询的方法
     * 动态根据DUser实体类已经有的属性进行查找
     * 如果属性越多越详细 查询的条件相对变多
     * @param user 用户实体
     * @return 后台管理员用户
     */
    DUser selectByEntity(DUser user) throws Exception;

    
}