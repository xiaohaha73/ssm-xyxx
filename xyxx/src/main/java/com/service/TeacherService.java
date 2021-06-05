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

    // 获取所有管理员
    public List<Teacher> getTeachers () {
        return teacherMapper.getTeachers();
    }

    // 根据yhm获取管理员
    public Teacher getTeacherByYhm(@Param("yhm") String yhm) {
        return teacherMapper.getTeacherByYhm(yhm);
    }

}
