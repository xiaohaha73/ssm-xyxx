package com.service;

import com.dao.TeacherMapper;
import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    // 获取所有老师
    public List<Teacher> getTeachers () {
        return teacherMapper.getTeachers();
    }

    // 根据yhm获取老师
    public Teacher getTeacherByYhm(@Param("yhm") String yhm) {
        return teacherMapper.getTeacherByYhm(yhm);
    }

    // 根据id查询教师
    public Teacher getTeacherById(@Param("jsid") int jsid){
        return teacherMapper.getTeacherById(jsid);
    }

    // 添加老师
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    // 删除老师
    public int delTeacher(@Param("jsid") int jsid) {
        return teacherMapper.delTeacher(jsid);
    }

    // 更新老师
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

}
