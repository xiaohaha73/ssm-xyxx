package com.service;

import com.pojo.Xuanke;
import com.dao.XuankeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuankeService {

    @Autowired
    private XuankeMapper xuankeMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Xuanke> listAll() {
    	return xuankeMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param xkid 主键
     * @return 返回记录，没有返回null
     */
    public Xuanke getById(Integer xkid) {
    	return xuankeMapper.getById(xkid);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param xuanke 新增的记录
     * @return 返回影响行数
     */
    public int insert(Xuanke xuanke) {
    	return xuankeMapper.insert(xuanke);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param xuanke 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Xuanke xuanke) {
    	return xuankeMapper.insertIgnoreNull(xuanke);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param xuanke 修改的记录
     * @return 返回影响行数
     */
    public int update(Xuanke xuanke) {
    	return xuankeMapper.update(xuanke);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param xuanke 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Xuanke xuanke) {
    	return xuankeMapper.updateIgnoreNull(xuanke);
    }
	
    /**
     * 删除记录
     *
     * @param xkid 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer xkid) {
    	return xuankeMapper.delete(xkid);
    }
	
}