package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pfbl {
	private String mc;
	private Integer pfblid;
	/** 平时 */
	private String ps;
	/** 期末 */
	private String qm;

}