package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 管理员
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int glyid;
    private String yhm; // 用户名
    private String mm; // 密码
    private String xm; // 姓名

    public Admin(String yhm, String mm, String xm) {
        this.yhm = yhm;
        this.mm = mm;
        this.xm = xm;
    }
}
