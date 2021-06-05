package com.dao;

import com.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    // 查找所有管理员
    List<Admin> getAdmins();

    // 根据用户名yhm查找管理员
    Admin getAdminByYhm(String yhm);
}
