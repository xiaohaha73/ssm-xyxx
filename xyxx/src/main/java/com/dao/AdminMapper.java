package com.dao;

import com.pojo.Admin;

import java.util.HashMap;
import java.util.List;

public interface AdminMapper {

    // 查找所有管理员
    // List<Admin> getAdmins();
    // 添加分页功能
    List<Admin> getAdmins(HashMap<String,Integer> map);

    // 根据用户名yhm查找管理员
    Admin getAdminByYhm(String yhm);

    // 根据id值查询管理员
    Admin getAdminById(int glyid);

    // 添加管理员
    int addAdmin(Admin admin);

    // 根据id删除管理员
    int delAdmin(int glyid);

    // 更新管理员
    int updateAdmin(Admin admin);
}
