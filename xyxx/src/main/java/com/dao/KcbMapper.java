package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Kcb;

@Mapper
public interface KcbMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Kcb> listAll();


	/**
     * 根据主键查询
     *
     * @param kcbid 主键
     * @return 返回记录，没有返回null
     */
	Kcb getById(Integer kcbid);
	
	/**
     * 新增，插入所有字段
     *
     * @param kcb 新增的记录
     * @return 返回影响行数
     */
	int insert(Kcb kcb);
	
	/**
     * 新增，忽略null字段
     *
     * @param kcb 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Kcb kcb);
	
	/**
     * 修改，修改所有字段
     *
     * @param kcb 修改的记录
     * @return 返回影响行数
     */
	int update(Kcb kcb);
	
	/**
     * 修改，忽略null字段
     *
     * @param kcb 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Kcb kcb);
	
	/**
     * 删除记录
     *
     * @param kcbid 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer kcbid);
	
}