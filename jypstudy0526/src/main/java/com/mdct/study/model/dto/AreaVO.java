package com.mdct.study.model.dto;

public class AreaVO {
	private String area_cd;
	private String cd_nm;
	
	public String getArea_cd() {
		return area_cd;
	}
	public void setArea_cd(String area_cd) {
		this.area_cd = area_cd;
	}
	public String getCd_nm() {
		return cd_nm;
	}
	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}
	
	@Override
	public String toString() {
		return "AreaVO [area_cd=" + area_cd + ", cd_nm=" + cd_nm +"]";
	}

}
