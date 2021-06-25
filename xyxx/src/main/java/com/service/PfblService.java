package com.service;

import com.pojo.Pfbl;
import com.dao.PfblMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PfblService {

    @Autowired
    private PfblMapper pfblMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Pfbl> listAll() {
    	return pfblMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     *
     * @return 返回记录，没有返回null
     */
    public Pfbl getById(Integer pfblid) {
    	return pfblMapper.getById(pfblid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param pfbl 新增的记录
     * @return 返回影响行数
     */
    public int insert(Pfbl pfbl) {
    	return pfblMapper.insert(pfbl);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param pfbl 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Pfbl pfbl) {
    	return pfblMapper.insertIgnoreNull(pfbl);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param pfbl 修改的记录
     * @return 返回影响行数
     */
    public int update(Pfbl pfbl) {
    	return pfblMapper.update(pfbl);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param pfbl 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Pfbl pfbl) {
    	return pfblMapper.updateIgnoreNull(pfbl);
    }
	
    /**
     * 删除记录
     *
     * @param pfblid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(int pfblid) {
    	return pfblMapper.delete(pfblid);
    }
	
}