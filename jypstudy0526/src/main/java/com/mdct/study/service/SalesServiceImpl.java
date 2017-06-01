package com.mdct.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mdct.study.model.dao.SalesDAO;
import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

@Service
public class SalesServiceImpl implements SalesService {

	@Inject
	SalesDAO salesDAO;
	
	//세일즈목록
	@Override
	public List<SalesVO> salesList(int value) {
		System.out.println("this is SalesServiceImpl page"+value);
		return salesDAO.salesList(value);
	}

}
