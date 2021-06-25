package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Pfbl;

@Mapper
public interface PfblMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Pfbl> listAll();


	/**
     * 根据主键查询
     *
     *
     * @return 返回记录，没有返回null
     */
	Pfbl getById(Integer pfblid);
	
	/**
     * 新增，插入所有字段
     *
     * @param pfbl 新增的记录
     * @return 返回影响行数
     */
	int insert(Pfbl pfbl);
	
	/**
     * 新增，忽略null字段
     *
     * @param pfbl 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Pfbl pfbl);
	
	/**
     * 修改，修改所有字段
     *
     * @param pfbl 修改的记录
     * @return 返回影响行数
     */
	int update(Pfbl pfbl);
	
	/**
     * 修改，忽略null字段
     *
     * @param pfbl 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Pfbl pfbl);
	
	/**
     * 删除记录
     *
     * @param pfblid 待删除的记录
     * @return 返回影响行数
     */
	int delete(int pfblid);
	
}