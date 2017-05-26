package com.mdct.study.model.dto;

public class SalesVO {
	private String area_cd;
	private String prod_id;
	private int sales_cnt;
	private String region_area;
	private String cd_nm;
	private String prod_nm;
	
	//getter&setter
	public String getArea_cd() {
		return area_cd;
	}
	public String getProd_id() {
		return prod_id;
	}
	public int getSales_cnt() {
		return sales_cnt;
	}
	public String getRegion_area() {
		return region_area;
	}
	public String getCd_nm() {
		return cd_nm;
	}
	public String getProd_nm() {
		return prod_nm;
	}
	public void setArea_cd(String area_cd) {
		this.area_cd = area_cd;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public void setSales_cnt(int sales_cnt) {
		this.sales_cnt = sales_cnt;
	}
	public void setRegion_area(String region_area) {
		this.region_area = region_area;
	}
	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}
	public void setProd_nm(String prod_nm) {
		this.prod_nm = prod_nm;
	}
	
	@Override
	public String toString() {
		return "SalesVO [area_cd=" + area_cd + ", prod_id=" + prod_id + ", sales_cnt=" + sales_cnt + ", region_area="
				+ region_area + ", cd_nm=" + cd_nm + ", prod_nm=" + prod_nm + "]";
	}
}
