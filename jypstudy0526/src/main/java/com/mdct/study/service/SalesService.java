package com.mdct.study.service;

import java.util.List;

import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

public interface SalesService {
	//세일즈목록
	public List<SalesVO> salesList(int value);
	
}
