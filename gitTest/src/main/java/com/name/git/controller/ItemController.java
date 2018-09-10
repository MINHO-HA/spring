package com.name.git.controller;




import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.service.ItemService;
import com.name.git.vo.ItemVO;

import com.name.git.vo.ReviewVO;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	private ModelAndView modelAndView;
	
	@Autowired
	HttpSession session;
	
	
	//메인에서 검색어 입력시 처리
	@RequestMapping(value="/searchItem", method = RequestMethod.GET)
	public ModelAndView searchingSth(@RequestParam("MEM_ID") String id, @ModelAttribute ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.searchItem(id, itemVO);
		
		return modelAndView;
	}

	
	
	//제품 상세 페이지(이미지 클릭시)
	@RequestMapping(value="/viewItem", method = RequestMethod.GET)
	public ModelAndView viewItem(@ModelAttribute ReviewVO reviewVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.viewItem(reviewVO);
		
		return modelAndView;
	}
	
	
	
	//리뷰작성 페이지로 이동
	@RequestMapping(value = "/writeReview" ,  method = RequestMethod.GET)
	public String writeReview() {
		
		return "writeReviewForm";
	}
	
	
	
	//리뷰 작성
	@RequestMapping(value="/writeReviewForm", method = RequestMethod.POST)
	public ModelAndView writeReview(@ModelAttribute ReviewVO reviewVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.writeReview(reviewVO, response);
		
		return modelAndView;
	}
	
	
}
