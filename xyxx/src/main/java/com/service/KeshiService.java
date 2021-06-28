package com.service;

import com.pojo.Keshi;
import com.dao.KeshiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeshiService {

    @Autowired
    private KeshiMapper keshiMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Keshi> listAll() {
    	return keshiMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Keshi getById(Integer ksid) {
    	return keshiMapper.getById(ksid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param keshi 新增的记录
     * @return 返回影响行数
     */
    public int insert(Keshi keshi) {
    	return keshiMapper.insert(keshi);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param keshi 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Keshi keshi) {
    	return keshiMapper.insertIgnoreNull(keshi);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param keshi 修改的记录
     * @return 返回影响行数
     */
    public int update(Keshi keshi) {
    	return keshiMapper.update(keshi);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param keshi 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Keshi keshi) {
    	return keshiMapper.updateIgnoreNull(keshi);
    }
	
    /**
     * 删除记录
     *
     * @param keshi 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer ksid) {
    	return keshiMapper.delete(ksid);
    }
	
}