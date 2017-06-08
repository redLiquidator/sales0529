package com.mdct.study.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("list.do")
	public String salesList1(Model model){
		System.out.println("start");
		List<AreaVO> areaList=salesService.areaList();
		model.addAttribute("areaList",areaList);
		return "sales/sales_list";
	}
	//sales 목록
	@RequestMapping(value="list.do", method=RequestMethod.POST)
	public String salesList(Model model,String city,String direction){
		
		System.out.println("start");
		List<AreaVO> areaList=salesService.areaList();
		model.addAttribute("areaList",areaList);
		
		int dir=Integer.parseInt(direction);
		
		System.out.println("you entered value:"+city+dir);
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		map.put("city",city);
		map.put("direction", dir);
		System.out.println(""
				+ "map.get(city) says..."+map.get("city")+
				"  map.get(direction) says"+map.get("direction"));
		List<SalesVO> list=salesService.salesList(map);
		model.addAttribute("list",list);
		return "sales/sales_list";
	}

	@RequestMapping("insert.do")
	public String salesAdd(Model model){
		return "sales/sales_add";
	}
}
