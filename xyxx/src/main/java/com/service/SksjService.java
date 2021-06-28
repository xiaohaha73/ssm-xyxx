package com.service;

import com.pojo.Sksj;
import com.dao.SksjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SksjService {

    @Autowired
    private SksjMapper sksjMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Sksj> listAll() {
    	return sksjMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param sksjid 主键
     * @return 返回记录，没有返回null
     */
    public Sksj getById(Integer sksjid) {
    	return sksjMapper.getById(sksjid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sksj 新增的记录
     * @return 返回影响行数
     */
    public int insert(Sksj sksj) {
    	return sksjMapper.insert(sksj);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sksj 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Sksj sksj) {
    	return sksjMapper.insertIgnoreNull(sksj);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sksj 修改的记录
     * @return 返回影响行数
     */
    public int update(Sksj sksj) {
    	return sksjMapper.update(sksj);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sksj 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Sksj sksj) {
    	return sksjMapper.updateIgnoreNull(sksj);
    }
	
    /**
     * 删除记录
     *
     * @param sksjid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(int sksjid) {
    	return sksjMapper.delete(sksjid);
    }
	
}