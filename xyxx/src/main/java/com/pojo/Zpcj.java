package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zpcj {
	/** 登记时间 */
	private String djsj;
	/** 课程 */
	private String kc;
	/** 平时成绩 */
	private String pscj;
	/** 期末成绩 */
	private String qmcj;
	/** 学生 */
	private String xs;
	/** 总成绩 */
	private String zcj;
	private Integer zpcjid;

}