package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.Xq;

@Mapper
public interface XqMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Xq> listAll();

	
	/**
     * 新增，插入所有字段
     *
     * @param xq 新增的记录
     * @return 返回影响行数
     */
	int insert(Xq xq);
	
	/**
     * 新增，忽略null字段
     *
     * @param xq 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Xq xq);

}