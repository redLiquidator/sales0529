package com.mdct.study.model.dto;

public class SalesVO {
	private String ename;
	private String job;
	private int deptno;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "SalesVO [ename=" + ename + ", job=" + job + 
				", deptno=" + deptno + "]";
	}
}
