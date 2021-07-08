package com.service;

import com.pojo.Chengji;
import com.dao.ChengjiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChengjiService {

    @Autowired
    private ChengjiMapper chengjiMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Chengji> listAll() {
    	return chengjiMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param cjid 主键
     * @return 返回记录，没有返回null
     */
    public Chengji getById(Integer cjid) {
    	return chengjiMapper.getById(cjid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param chengji 新增的记录
     * @return 返回影响行数
     */
    public int insert(Chengji chengji) {
    	return chengjiMapper.insert(chengji);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param chengji 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Chengji chengji) {
    	return chengjiMapper.insertIgnoreNull(chengji);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param chengji 修改的记录
     * @return 返回影响行数
     */
    public int update(Chengji chengji) {
    	return chengjiMapper.update(chengji);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param chengji 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Chengji chengji) {
    	return chengjiMapper.updateIgnoreNull(chengji);
    }
	
    /**
     * 删除记录
     *
     * @param cjid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer cjid) {
    	return chengjiMapper.delete(cjid);
    }
	
}