package com.service;

import com.pojo.Kecheng;
import com.dao.KechengMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KechengService {

    @Autowired
    private KechengMapper kechengMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Kecheng> listAll() {
    	return kechengMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param kcid 主键
     * @return 返回记录，没有返回null
     */
    public Kecheng getById(Integer kcid) {
    	return kechengMapper.getById(kcid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param kecheng 新增的记录
     * @return 返回影响行数
     */
    public int insert(Kecheng kecheng) {
    	return kechengMapper.insert(kecheng);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param kecheng 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Kecheng kecheng) {
    	return kechengMapper.insertIgnoreNull(kecheng);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param kecheng 修改的记录
     * @return 返回影响行数
     */
    public int update(Kecheng kecheng) {
    	return kechengMapper.update(kecheng);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param kecheng 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Kecheng kecheng) {
    	return kechengMapper.updateIgnoreNull(kecheng);
    }
	
    /**
     * 删除记录
     *
     * @param kecheng 待删除的记录
     * @return 返回影响行数
     */
    public int delete(int keyid) {
    	return kechengMapper.delete(keyid);
    }
	
}