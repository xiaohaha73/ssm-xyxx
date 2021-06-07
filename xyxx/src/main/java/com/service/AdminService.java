package com.service;


import com.dao.AdminMapper;
import com.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    // 获取所有管理员
    public List<Admin> getAdmins (HashMap<String,Integer> map) {
        // 给分页的参数设定默认值
        if (map.isEmpty()) {
            HashMap<String,Integer> defaultMap = new HashMap<String, Integer>();
            defaultMap.put("startIndex",1); // 默认显示第1页
            defaultMap.put("pageSize",4); // 默认4条数据
            return adminMapper.getAdmins(defaultMap);
        }
        return adminMapper.getAdmins(map);
    }

    // 根据yhm获取管理员
    public Admin getAdminByYhm(@Param("yhm") String yhm) {
        return adminMapper.getAdminByYhm(yhm);
    }

    // 根据id值查询管理员
    public Admin getAdminById(int glyid) {
        return adminMapper.getAdminById(glyid);
    }

    // 添加管理员
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    // 根据id删除管理员
    public int delAdmin(int glyid) {
        return adminMapper.delAdmin(glyid);
    }


    // 更新管理员
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }


}
