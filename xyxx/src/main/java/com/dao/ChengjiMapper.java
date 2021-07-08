package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Chengji;

@Mapper
public interface ChengjiMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Chengji> listAll();


	/**
     * 根据主键查询
     *
     * @param cjid 主键
     * @return 返回记录，没有返回null
     */
	Chengji getById(Integer cjid);
	
	/**
     * 新增，插入所有字段
     *
     * @param chengji 新增的记录
     * @return 返回影响行数
     */
	int insert(Chengji chengji);
	
	/**
     * 新增，忽略null字段
     *
     * @param chengji 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Chengji chengji);
	
	/**
     * 修改，修改所有字段
     *
     * @param chengji 修改的记录
     * @return 返回影响行数
     */
	int update(Chengji chengji);
	
	/**
     * 修改，忽略null字段
     *
     * @param chengji 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Chengji chengji);
	
	/**
     * 删除记录
     *
     * @param cjid 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer cjid);
	
}