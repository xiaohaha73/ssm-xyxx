package com.service;

import com.pojo.Zpcj;
import com.dao.ZpcjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZpcjService {

    @Autowired
    private ZpcjMapper zpcjMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Zpcj> listAll() {
    	return zpcjMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param zpcjid 主键
     * @return 返回记录，没有返回null
     */
    public Zpcj getById(Integer zpcjid) {
    	return zpcjMapper.getById(zpcjid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param zpcj 新增的记录
     * @return 返回影响行数
     */
    public int insert(Zpcj zpcj) {
    	return zpcjMapper.insert(zpcj);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param zpcj 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Zpcj zpcj) {
    	return zpcjMapper.insertIgnoreNull(zpcj);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param zpcj 修改的记录
     * @return 返回影响行数
     */
    public int update(Zpcj zpcj) {
    	return zpcjMapper.update(zpcj);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param zpcj 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Zpcj zpcj) {
    	return zpcjMapper.updateIgnoreNull(zpcj);
    }
	
    /**
     * 删除记录
     *
     * @param zpcjid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer zpcjid) {
    	return zpcjMapper.delete(zpcjid);
    }
	
}