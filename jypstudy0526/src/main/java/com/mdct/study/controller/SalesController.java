package com.mdct.study.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mdct.study.service.SalesService;
import com.mdct.study.model.dto.AreaVO;
import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/sales/*")
public class SalesController {
	
	
	@Inject
	SalesService salesService;
	
	
	//sales 목록
	@RequestMapping("list.do")
	public String salesList(Model model,String city,int direction){
		List<AreaVO> areaList=salesService.areaList();
		System.out.println("you entered value:"+city+direction);
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("city",city);
		map.put("direction", direction);
		System.out.println(""
				+ "map.get(city) says..."+map.get(city)+
				"  map.get(direction) says"+map.get(direction));
		List<SalesVO> list = salesService.salesList(map);
		
		model.addAttribute("list",list);
		model.addAttribute("areaList",areaList);
		return "sales/sales_list";
	}

	@RequestMapping("insert.do")
	public String salesAdd(Model model){
		return "sales/sales_add";
	}
}
