package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Keshi;

@Mapper
public interface KeshiMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Keshi> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Keshi getById(Integer ksid);
	
	/**
     * 新增，插入所有字段
     *
     * @param keshi 新增的记录
     * @return 返回影响行数
     */
	int insert(Keshi keshi);
	
	/**
     * 新增，忽略null字段
     *
     * @param keshi 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Keshi keshi);
	
	/**
     * 修改，修改所有字段
     *
     * @param keshi 修改的记录
     * @return 返回影响行数
     */
	int update(Keshi keshi);
	
	/**
     * 修改，忽略null字段
     *
     * @param keshi 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Keshi keshi);
	
	/**
     * 删除记录
     *
     * @param keshi 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer ksid);
	
}