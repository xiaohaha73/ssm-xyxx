package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 查询所有学生
    List<Student> getStudents();

    // 根据yhm查询学生
    Student getStudentByYhm(String yhm);

    // 根据xsid查询学生
    Student getStudentById(int xsid);

    // 更改学生信息
    int updateStudent(Student student);

    // 删除学生
    int delStudent(int xsid);

    // 添加学生
    int addStudent(Student student);

}
