package com.service;

import com.dao.StudentMapper;
import com.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // 获取所有管理员
    public List<Student> getStudents () {
        return studentMapper.getStudents();
    }

    // 根据yhm获取管理员
    public Student getStudentByYhm(@Param("yhm") String yhm) {
        return studentMapper.getStudentByYhm(yhm);
    }


    // 根据xsid查询学生
    public Student getStudentById(int xsid) {
        return studentMapper.getStudentById(xsid);
    }

    // 更改学生信息
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    // 删除学生
    public int delStudent(int xsid) {
        return studentMapper.delStudent(xsid);
    }

    // 添加学生
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
}
