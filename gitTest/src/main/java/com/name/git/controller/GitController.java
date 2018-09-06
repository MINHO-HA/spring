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

@Controller
public class GitController {

	@Autowired
	private GitService gs;
	private ModelAndView mav;
	
	@Autowired
	HttpSession session;
	
	//제일 처음 띄울 페이지
	@RequestMapping(value = "/" ,  method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	//로그인 페이지
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	//회원가입 페이지로 이동
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUp() {	
		return "signUp";
	}
	
	//마이 페이지
	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public String myPage() {	
		return "myPage";
	}
	
	//회원가입 페이지
	@RequestMapping(value = "joinForm", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		
		mav = gs.memberJoin(memberVO);
		return mav;
	}
	//로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = gs.memberLogin(memberVO, response);
		return mav;
	}
	
	//마이페이지에서 비밀번호 확인
	@RequestMapping(value = "passwordForCheck", method = RequestMethod.POST)
	public ModelAndView passwordChecking(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = gs.passwordChecking(memberVO, response);
		return mav;
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
		mav = new ModelAndView();
		mav = gs.personalInfo(id);
		return mav;
	}
	
	//개인정보 변경 처리
	@RequestMapping(value="/modifyPersonalInfo", method = RequestMethod.POST)
	public ModelAndView modifyPersonalInfo(@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		mav = gs.modifyPersonalInfo(memberVO);
		
		return mav;
	}
	
	//메인에서 검색어 입력시 처리
	@RequestMapping(value="/searchingSth", method = RequestMethod.GET)
	public ModelAndView searchingSth(@RequestParam("MEM_ID") String id, @ModelAttribute ItemVO itemVO) {
		mav = new ModelAndView();
		mav = gs.searchingSth(id, itemVO);
		
		return mav;
	}
	

}
