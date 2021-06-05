package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer xsid;
    private String yhm; // 用户名
    private String mm; // 密码
    private String xm; // 姓名
    private String zy; // 专业
    private String xy; // 学院
    private String nl; // 年龄
    private String dh; // 电话
    private String dj; // 班级
}
