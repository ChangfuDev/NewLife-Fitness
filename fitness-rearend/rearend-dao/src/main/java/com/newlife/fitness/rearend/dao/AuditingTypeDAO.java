package com.newlife.fitness.rearend.dao;

import com.newlife.fitness.entity.AuditingType;

public interface AuditingTypeDAO {
	/**
	 * 根据主键进行删除的方法
	 * @param id 主键id
	 * @return 返回受影响行数
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条审核信息的方法
     * @param record 实体
     * @return 返回插入影响行数
     */
    int insert(AuditingType record);

    /**
     * 根据主键进行查询的方法
     * @param id 主键id
     * @return 返回一个实体对象
     */
    AuditingType selectByPrimaryKey(Integer id);
    
    /**
     * 更新的方法 传入一个实体类。
     * 根据实体类包含的属性进行动态判断需要修改的东西
     * @param record 传入实体参数
     * @return 返回更新的行数
     */
    int updateByPrimaryKey(AuditingType record);

}