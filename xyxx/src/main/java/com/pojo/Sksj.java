package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sksj {
	/** 节 */
	private String j;
	/** 课程 */
	private String kc;
	private Integer sksjid;
	/** 星期 */
	private String xq;
}