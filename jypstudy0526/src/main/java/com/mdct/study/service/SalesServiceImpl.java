package com.mdct.study.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mdct.study.model.dao.SalesDAO;
import com.mdct.study.model.dto.AreaVO;
import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

@Service
public class SalesServiceImpl implements SalesService {

	@Inject
	SalesDAO salesDAO;
	
	//세일즈목록
	@Override
	public List<SalesVO> salesList(HashMap<String, Object> map) {
		System.out.println("this is SalesServiceImpl page"+map.get("city")+map.get("direction"));
		return salesDAO.salesList(map);
	}
	
	@Override
	public List<AreaVO> areaList(){
		System.out.println("we got"+salesDAO.areaList());
		return salesDAO.areaList();
	};
	

}
