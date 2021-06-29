package com.service;

import com.pojo.Kcb;
import com.dao.KcbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KcbService {

    @Autowired
    private KcbMapper kcbMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Kcb> listAll() {
    	return kcbMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param kcbid 主键
     * @return 返回记录，没有返回null
     */
    public Kcb getById(Integer kcbid) {
    	return kcbMapper.getById(kcbid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param kcb 新增的记录
     * @return 返回影响行数
     */
    public int insert(Kcb kcb) {
    	return kcbMapper.insert(kcb);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param kcb 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Kcb kcb) {
    	return kcbMapper.insertIgnoreNull(kcb);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param kcb 修改的记录
     * @return 返回影响行数
     */
    public int update(Kcb kcb) {
    	return kcbMapper.update(kcb);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param kcb 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Kcb kcb) {
    	return kcbMapper.updateIgnoreNull(kcb);
    }
	
    /**
     * 删除记录
     *
     * @param kcbid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer kcbid) {
    	return kcbMapper.delete(kcbid);
    }
	
}