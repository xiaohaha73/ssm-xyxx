package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Kecheng;

@Mapper
public interface KechengMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Kecheng> listAll();


	/**
     * 根据主键查询
     *
     * @param kcid 主键
     * @return 返回记录，没有返回null
     */
	Kecheng getById(Integer kcid);
	
	/**
     * 新增，插入所有字段
     *
     * @param kecheng 新增的记录
     * @return 返回影响行数
     */
	int insert(Kecheng kecheng);
	
	/**
     * 新增，忽略null字段
     *
     * @param kecheng 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Kecheng kecheng);
	
	/**
     * 修改，修改所有字段
     *
     * @param kecheng 修改的记录
     * @return 返回影响行数
     */
	int update(Kecheng kecheng);
	
	/**
     * 修改，忽略null字段
     *
     * @param kecheng 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Kecheng kecheng);
	
	/**
     * 删除记录
     *
     * @param keyid 待删除的记录
     * @return 返回影响行数
     */
	int delete(int keyid);
	
}