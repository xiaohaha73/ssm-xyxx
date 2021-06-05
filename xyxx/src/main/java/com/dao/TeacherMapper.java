package com.dao;

import com.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    // 查询所有老师
    List<Teacher> getTeachers();

    // 根据yhm查询老师
    Teacher getTeacherByYhm(String yhm);
}
