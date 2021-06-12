package com.dao;

import com.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    // 查询所有老师
    List<Teacher> getTeachers();

    // 根据yhm查询老师
    Teacher getTeacherByYhm(String yhm);

    // 根据id查询教师
    Teacher getTeacherById(int jsid);

    // 添加教师
    int addTeacher(Teacher teacher);

    // 根据jsid删除老师
    int delTeacher(int jsid);

    // 更新老师
    int updateTeacher(Teacher teacher);
}
