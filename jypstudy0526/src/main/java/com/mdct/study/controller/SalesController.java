package com.mdct.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mdct.study.service.SalesService;
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
	public String salesList(Model model,Integer no){
		no=20;
		System.out.println(no);
		List<SalesVO> list = salesService.salesList(no);
		model.addAttribute("list",list);
		return "sales/sales_list";
	}
	
	@RequestMapping("insert.do")
	public String salesAdd(Model model){
		return "sales/sales_add";
	}
}
