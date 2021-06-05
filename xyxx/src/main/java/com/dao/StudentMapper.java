package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 查询所有学生
    List<Student> getStudents();

    // 根据yhm查询学生
    Student getStudentByYhm(String yhm);
}
