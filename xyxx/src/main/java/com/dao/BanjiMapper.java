package com.dao;

import com.pojo.Banji;

import java.util.List;

public interface BanjiMapper {

    // 查询所有班级
    List<Banji> getBanjis();

    // 根据bjid查询班级
    Banji getBanjiByid(int bjid);

    // 添加班级
    int addBanji(Banji banji);

    // 根据id删除班级
    int delBanji(int bjid);

    // 修改班级信息
    int updateBanji(Banji banji);

}
