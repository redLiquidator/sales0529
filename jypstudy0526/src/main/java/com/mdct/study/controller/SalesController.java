package com.mdct.study.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mdct.study.service.SalesService;
import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

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
	//@RequestMapping(value="list.do", method=RequestMethod.POST)
	//public String salesList(Model model,Parameter parameter){
	public String salesList(Model model,Parameter value){
		//int value=parameter.getNo();
		System.out.println("you entered"+value);
		System.out.println("aaaaaaaaaaa");
		List<SalesVO> list = salesService.salesList(value);
		model.addAttribute("list",list);
		return "sales/sales_list";
	}
	
/*	@RequestMapping("list.do/{value}")
	public String getItemById(@PathVariable Parameter value, Model model) {
		System.out.println(value);
		
		List<SalesVO> list = salesService.salesList(value);
		model.addAttribute("list",list);
		
		return "sales/sales_list";
	}*/
	@RequestMapping("insert.do")
	public String salesAdd(Model model){
		return "sales/sales_add";
	}
}
