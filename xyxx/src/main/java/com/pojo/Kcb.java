package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kcb {
	/** 课程 */
	private String kc;
	private Integer kcbid;
	private String ks;
	/** 上课地点 */
	private String skdd;
	/** 上课时间 */
	private String sksj;
	/** 说明 */
	private String sm;

}