package com.name.git.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.service.GitService;
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
		System.out.println("확인용 id : "+memberVO.getMEM_ID());
		System.out.println("확인용 pw : "+memberVO.getMEM_PW());
		System.out.println("확인용 이름 : "+memberVO.getMEM_NAME());
		System.out.println("확인용 나이 : "+memberVO.getMEM_AGE());
		System.out.println("확인용 성별 : "+memberVO.getMEM_GENDER());
		System.out.println("확인용 피부타입 : "+memberVO.getMEM_SKINTYPE());
		
		mav = gs.memberJoin(memberVO);
		return mav;
	}
	
	/*//로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView memberlogin(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = gs.memberlogin(memberVO, response);
		return mav;
	}*/

	
}
