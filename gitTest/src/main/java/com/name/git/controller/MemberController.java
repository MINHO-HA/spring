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

import com.name.git.service.MemberService;
import com.name.git.vo.MemberVO;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	private ModelAndView modelAndView;
	
	@Autowired
	HttpSession session;
	
	//제일 처음 띄울 페이지
	@RequestMapping(value = "/" ,  method = RequestMethod.GET)
	public String main() {
		
		return "main";	
	}
	
	//회원가입 페이지로 이동
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		
		return "signUp";
	}
			
	//회원가입 페이지
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberVO memberVO) {
		
		//MEMBER 테이블의 AGE_ID위한 처리과정
		if(memberVO.getMEM_AGE() >= 0 && memberVO.getMEM_AGE() < 20 ) {
			memberVO.setAGE_ID(1);
		} else if (memberVO.getMEM_AGE() >= 20 && memberVO.getMEM_AGE() < 30 ) {
			memberVO.setAGE_ID(2);
		} else if (memberVO.getMEM_AGE() >= 30 && memberVO.getMEM_AGE() < 40 ) {
			memberVO.setAGE_ID(3);
		} else if (memberVO.getMEM_AGE() >= 40 && memberVO.getMEM_AGE() < 50 ) {
			memberVO.setAGE_ID(4);
		} else {
			memberVO.setAGE_ID(5);
		}
		
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberJoin(memberVO);
		
		return modelAndView;
	}	
		
	//로그인 페이지
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() {
		
		return "loginPage";	
	}
	
	//로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView memberLogin(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
			
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberLogin(memberVO, response);
			
		return modelAndView;	
	}
	
	//로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		
		session.invalidate();
		
		return "main";
	}
	
	
	
	//마이 페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		
		return "myPageAuth";	
	}
	
	//마이페이지에서 비밀번호 확인
	@RequestMapping(value = "/passwordForCheck", method = RequestMethod.POST)
	public ModelAndView passwordChecking(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		modelAndView = memberService.passwordChecking(memberVO, response);
		
		return modelAndView;
	}
	
	//개인정보 보기
	@RequestMapping(value="/personalInfo", method = RequestMethod.GET)
	public ModelAndView personalInfo(HttpServletResponse response, @RequestParam("id") String id) {
		
		modelAndView = new ModelAndView();
		modelAndView = memberService.personalInfo(id);
		
		return modelAndView;
	}
	
	//개인정보 변경 처리
	@RequestMapping(value="/modifyPersonalInfo", method = RequestMethod.POST)
	public ModelAndView modifyPersonalInfo(@ModelAttribute MemberVO memberVO) {
		
		modelAndView = new ModelAndView();
		modelAndView = memberService.modifyPersonalInfo(memberVO);
		
		return modelAndView;
	}
	
}
