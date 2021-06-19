package com.service;

import com.dao.BanjiMapper;
import com.pojo.Banji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BanjiService {

    @Autowired
    private BanjiMapper banjiMapper;

    // 查询所有的班级
    public List<Banji> getBanjis() {
        return banjiMapper.getBanjis();
    }

    // 添加班级
    public int addBanji(Banji banji) {
        return banjiMapper.addBanji(banji);
    }

    // 根据bjid查询班级
    public Banji getBanjiByid(int bjid) {
        return banjiMapper.getBanjiByid(bjid);
    }

    // 根据id删除班级
    public int delBanji(int bjid) {
        return banjiMapper.delBanji(bjid);
    }

    // 修改班级信息
    public int updateBanji(Banji banji){
        return banjiMapper.updateBanji(banji);
    }

}
