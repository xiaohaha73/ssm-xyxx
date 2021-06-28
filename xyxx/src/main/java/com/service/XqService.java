package com.service;

import com.pojo.Xq;
import com.dao.XqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XqService {

    @Autowired
    private XqMapper xqMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Xq> listAll() {
    	return xqMapper.listAll();
    }

	
    /**
     * 新增，插入所有字段
     *
     * @param xq 新增的记录
     * @return 返回影响行数
     */
    public int insert(Xq xq) {
    	return xqMapper.insert(xq);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param xq 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Xq xq) {
    	return xqMapper.insertIgnoreNull(xq);
    }
	

}