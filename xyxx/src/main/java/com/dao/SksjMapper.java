package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Sksj;

@Mapper
public interface SksjMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Sksj> listAll();


	/**
     * 根据主键查询
     *
     * @param sksjid 主键
     * @return 返回记录，没有返回null
     */
	Sksj getById(Integer sksjid);
	
	/**
     * 新增，插入所有字段
     *
     * @param sksj 新增的记录
     * @return 返回影响行数
     */
	int insert(Sksj sksj);
	
	/**
     * 新增，忽略null字段
     *
     * @param sksj 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Sksj sksj);
	
	/**
     * 修改，修改所有字段
     *
     * @param sksj 修改的记录
     * @return 返回影响行数
     */
	int update(Sksj sksj);
	
	/**
     * 修改，忽略null字段
     *
     * @param sksj 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Sksj sksj);
	
	/**
     * 删除记录
     *
     * @param sksjid 待删除的记录
     * @return 返回影响行数
     */
	int delete(int sksjid);
	
}