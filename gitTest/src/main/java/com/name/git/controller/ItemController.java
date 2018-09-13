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
import com.name.git.vo.LikedVO;
import com.name.git.vo.ReviewVO;
import com.name.git.vo.SelectedVO;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	private ModelAndView modelAndView;
	
	@Autowired
	HttpSession session;
	
	
	//메인에서 검색어 입력시 처리
	@RequestMapping(value="/searchItem", method = RequestMethod.GET)
	public ModelAndView searchingSth(@ModelAttribute ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.searchItem(itemVO);
		
		return modelAndView;
	}
	
	
	//검색필터 처리
	@RequestMapping(value="/searchFilter", method = RequestMethod.GET)
	public ModelAndView searchFilter(@ModelAttribute ItemVO itemVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.searchFilter(itemVO, response);
		
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
	@RequestMapping(value = "/reviewForm" ,  method = RequestMethod.GET)
	public String writeReview() {
		
		return "reviewWrite";
	}
	
	
	
	//리뷰 작성
	@RequestMapping(value="/writeReviewForm", method = RequestMethod.POST)
	public ModelAndView writeReview(@ModelAttribute ReviewVO reviewVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.writeReview(reviewVO, response);
		
		return modelAndView;
	}
	
	
	
	//내가 쓴 리뷰 
	@RequestMapping(value="/reviewsIWrote", method = RequestMethod.GET)
	public ModelAndView reviewsIWrote(@ModelAttribute ReviewVO reviewVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.reviewsIWrote(reviewVO);
		
		return modelAndView;
	}
	
	
	
	//리뷰 좋아요 올리기
	@RequestMapping(value="/raiseLike", method = RequestMethod.GET)
	public ModelAndView raiseLike(@ModelAttribute ReviewVO reviewVO, @ModelAttribute LikedVO likedVO, HttpServletResponse response) throws IOException {

		modelAndView = new ModelAndView();
		modelAndView = itemService.raiseLike(reviewVO, likedVO, response);
		
		return modelAndView;
	}
	
	
	
	//내가 좋아요한 리뷰
	@RequestMapping(value="/reviewsILiked", method = RequestMethod.GET)
	public ModelAndView reviewsILiked(@RequestParam("TARGET_MEM_ID") String id) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.reviewsILiked(id);
		
		return modelAndView;
	}
	
	
	
	//찜하기
	@RequestMapping(value="/markItem", method = RequestMethod.GET)
	public ModelAndView markItem(@ModelAttribute SelectedVO selectedVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.markItem(selectedVO, response);
		
		return modelAndView;
	}
	
	
	
	//내가 찜한 목록 보기(평균별점 추가해야함!)
	@RequestMapping(value="/listsIMarked", method = RequestMethod.GET)
	public ModelAndView listsIMarked(@RequestParam("MEM_ID") String id) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.listsIMarked(id);
		
		return modelAndView;
	}
	
	
	
	//리뷰 상세보기
	@RequestMapping(value="/viewReview", method = RequestMethod.GET)
	public ModelAndView viewReview(@RequestParam("REVIEW_ID") int id) {
		
		modelAndView = new ModelAndView();
		modelAndView = itemService.viewReview(id);
		
		return modelAndView;
		
	}
	
}
