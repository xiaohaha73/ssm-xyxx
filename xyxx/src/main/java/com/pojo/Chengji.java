package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chengji {
	/** 成绩 */
	private Integer cj;
	private Integer cjid;
	/** 登记时间 */
	private String djsj;
	/** 课程 */
	private String kc;
	/** 类别 */
	private String lb;
	/** 类型 */
	private String lx;
	/** 学生 */
	private String xs;

}