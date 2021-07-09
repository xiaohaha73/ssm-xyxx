package com.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chengji {
	/** 成绩 */
	@ExcelProperty("成绩")
	private Integer cj;
	@ExcelIgnore
	private Integer cjid;
	/** 登记时间 */
	@ExcelIgnore
	private String djsj;
	/** 课程 */
	@ExcelProperty("课程") // 使用easyexcel
	private String kc;
	/** 类别 */
	@ExcelProperty("类别")
	private String lb;
	/** 类型 */
	@ExcelProperty("类型")
	private String lx;
	/** 学生 */
	@ExcelProperty("学生")
	private String xs;

}