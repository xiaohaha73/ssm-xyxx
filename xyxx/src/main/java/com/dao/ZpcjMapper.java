package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Zpcj;

@Mapper
public interface ZpcjMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Zpcj> listAll();


	/**
     * 根据主键查询
     *
     * @param zpcjid 主键
     * @return 返回记录，没有返回null
     */
	Zpcj getById(Integer zpcjid);
	
	/**
     * 新增，插入所有字段
     *
     * @param zpcj 新增的记录
     * @return 返回影响行数
     */
	int insert(Zpcj zpcj);
	
	/**
     * 新增，忽略null字段
     *
     * @param zpcj 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Zpcj zpcj);
	
	/**
     * 修改，修改所有字段
     *
     * @param zpcj 修改的记录
     * @return 返回影响行数
     */
	int update(Zpcj zpcj);
	
	/**
     * 修改，忽略null字段
     *
     * @param zpcj 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Zpcj zpcj);
	
	/**
     * 删除记录
     *
     * @param zpcjid 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer zpcjid);
	
}