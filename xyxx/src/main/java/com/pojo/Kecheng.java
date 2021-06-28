package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kecheng {
	private String bl;
	/** 发布教师 */
	private String fbjs;
	/** 介绍 */
	private String js;
	private Integer kcid;
	/** 课程名称 */
	private String kcmc;

	public void setBl(String bl) {
		this.bl = bl;
	}
	
	public String getBl() {
		return this.bl;
	}
	
	public void setFbjs(String fbjs) {
		this.fbjs = fbjs;
	}
	
	public String getFbjs() {
		return this.fbjs;
	}
	
	public void setJs(String js) {
		this.js = js;
	}
	
	public String getJs() {
		return this.js;
	}
	
	public void setKcid(Integer kcid) {
		this.kcid = kcid;
	}
	
	public Integer getKcid() {
		return this.kcid;
	}
	
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	
	public String getKcmc() {
		return this.kcmc;
	}

}