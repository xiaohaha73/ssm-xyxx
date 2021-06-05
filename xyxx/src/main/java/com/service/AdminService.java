package com.service;


import com.dao.AdminMapper;
import com.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    // 获取所有管理员
    public List<Admin> getAdmins () {
        return adminMapper.getAdmins();
    }

    // 根据yhm获取管理员
    public Admin getAdminByYhm(@Param("yhm") String yhm) {
        return adminMapper.getAdminByYhm(yhm);
    }

}
