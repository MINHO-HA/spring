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

import com.name.git.service.GitService;
import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;

@Controller
public class GitController {

	@Autowired
	private GitService gitService;
	private ModelAndView modelAndView;
	
	@Autowired
	HttpSession session;
	
	
	
	//제일 처음 띄울 페이지
	@RequestMapping(value = "/" ,  method = RequestMethod.GET)
	public String main() {
		
		return "main";	
	}
	
	
	
	//로그인 페이지
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() {
		
		return "loginPage";	
	}
	
	
	
	//회원가입 페이지로 이동
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		
		return "signUp";
	}
	
	
	
	//마이 페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		
		return "myPage";	
	}
	
	
	
	//회원가입 페이지
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberVO memberVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.memberJoin(memberVO);
		
		return modelAndView;
	}
	
	
	
	//로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.memberLogin(memberVO, response);
		
		return modelAndView;	
	}
	
	
	
	//마이페이지에서 비밀번호 확인
	@RequestMapping(value = "/passwordForCheck", method = RequestMethod.POST)
	public ModelAndView passwordChecking(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.passwordChecking(memberVO, response);
		
		return modelAndView;
	}
	
	
	
	//로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		
		session.invalidate();
		
		return "main";
	}
	
	
	
	//개인정보 보기
	@RequestMapping(value="/personalInfo", method = RequestMethod.GET)
	public ModelAndView personalInfo(HttpServletResponse response, @RequestParam("id") String id) {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.personalInfo(id);
		
		return modelAndView;
	}
	
	
	
	//개인정보 변경 처리
	@RequestMapping(value="/modifyPersonalInfo", method = RequestMethod.POST)
	public ModelAndView modifyPersonalInfo(@ModelAttribute MemberVO memberVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.modifyPersonalInfo(memberVO);
		
		return modelAndView;
	}
	
	
	
	//메인에서 검색어 입력시 처리
	@RequestMapping(value="/searchingSth", method = RequestMethod.GET)
	public ModelAndView searchingSth(@RequestParam("MEM_ID") String id, @ModelAttribute ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.searchingKeyword(id, itemVO);
		
		return modelAndView;
	}

	
	
	//제품 상세 페이지(이미지 클릭시)
	@RequestMapping(value="/viewItem", method = RequestMethod.GET)
	public ModelAndView viewItem(@RequestParam("ITEM_ID") int id) {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.viewItem(id);
		
		return modelAndView;
	}
	
	
	
	//리뷰작성 페이지로 이동
	@RequestMapping(value = "/writeReview" ,  method = RequestMethod.GET)
	public String writeReview() {
		
		return "writeReviewForm";
	}
	
	
	
	//리뷰 작성
	@RequestMapping(value="/reviewWritingForm", method = RequestMethod.POST)
	public ModelAndView reviewWriting(@ModelAttribute ReviewVO reviewVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = gitService.reviewWriting(reviewVO, response);
		
		return modelAndView;
	}
	
	
}
