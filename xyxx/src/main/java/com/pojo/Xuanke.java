package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xuanke {
	/** 课程 */
	private String kc;
	private Integer xkid;
	/** 选课时间 */
	private String xksj;
	/** 学生 */
	private String xs;
	/** 状态 */
	private String zt;

}