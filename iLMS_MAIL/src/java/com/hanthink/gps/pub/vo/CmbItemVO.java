package com.hanthink.gps.pub.vo;

public class CmbItemVO {
	private String code;
	private String name;
	
	public CmbItemVO(){
		
	}
	public CmbItemVO(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
