package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Xuanke;

@Mapper
public interface XuankeMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Xuanke> listAll();


	/**
     * 根据主键查询
     *
     * @param xkid 主键
     * @return 返回记录，没有返回null
     */
	Xuanke getById(Integer xkid);
	
	/**
     * 新增，插入所有字段
     *
     * @param xuanke 新增的记录
     * @return 返回影响行数
     */
	int insert(Xuanke xuanke);
	
	/**
     * 新增，忽略null字段
     *
     * @param xuanke 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Xuanke xuanke);
	
	/**
     * 修改，修改所有字段
     *
     * @param xuanke 修改的记录
     * @return 返回影响行数
     */
	int update(Xuanke xuanke);
	
	/**
     * 修改，忽略null字段
     *
     * @param xuanke 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Xuanke xuanke);
	
	/**
     * 删除记录
     *
     * @param xkid 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer xkid);
	
}