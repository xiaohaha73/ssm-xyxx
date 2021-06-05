package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Integer jsid; // 教师id
    private String yhm; // 用户名
    private String mm; // 密码
    private String xm; // 姓名
    private String lxdh; // 联系电话
    private String lxdz; // 联系地址
    private String xy; // 学院
}
