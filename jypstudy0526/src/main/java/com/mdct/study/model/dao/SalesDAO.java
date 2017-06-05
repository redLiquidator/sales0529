package com.mdct.study.model.dao;

import java.util.HashMap;
import java.util.List;

import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

public interface SalesDAO {
	//세일즈목록
	public List<SalesVO> salesList(HashMap<Integer, Integer> map);
}
