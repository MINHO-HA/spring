package com.name.git.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.dao.GitDAO;
import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;

@Service
public class GitService {
	
	@Autowired
	private GitDAO gitDAO;
	private ModelAndView mav;
	private MemberVO memberVO;
	private ItemVO SearchedInfo;
	
	@Autowired
	private HttpSession session;
	
	//회원가입 처리
	public ModelAndView memberJoin(MemberVO memberVO) {
		mav = new ModelAndView();
		System.out.println("성별 : "+memberVO.getGENDER_ID());
		System.out.println("스킨타입 : "+memberVO.getSKINTYPE_ID());
		int result = gitDAO.memberJoin(memberVO);
		if(result == 0) {
			mav.setViewName("signUp");
		} else {
			mav.setViewName("main");
		}
		return mav;
	}

	//개인정보 페이지 비밀번호 확인
	public ModelAndView passwordChecking(MemberVO memberVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		mav = new ModelAndView();
		MemberVO password = gitDAO.passwordChecking(memberVO);
		PrintWriter out = response.getWriter();
		
		if(memberVO.getMEM_PW().equals(password.getMEM_PW())) {
			mav.addObject("check", memberVO);
			mav.setViewName("myPage");
		} else { 
			out.println("<script>"); 
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return mav;
	}
	
	//로그인 처리
	public ModelAndView memberLogin(MemberVO memberVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		mav = new ModelAndView();
		MemberVO loginMember = gitDAO.memberLogin(memberVO);
		PrintWriter out = response.getWriter();
		
		if(memberVO.getMEM_PW().equals(loginMember.getMEM_PW())) {
			session.setAttribute("session_id", memberVO.getMEM_ID());
			mav.setViewName("main");
		} else {
			// 로그인 실패 alert
			out.println("<script>"); 
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return mav;
	}

	//개인정보 보기
	public ModelAndView personalInfo(String id) {
		mav = new ModelAndView();
		memberVO = new MemberVO();
		memberVO = gitDAO.personalInfo(id);
		
		mav.addObject("personalInfo", memberVO);
		mav.setViewName("personalInfo");
	
		return mav;
	}

	//개인정보 변경
	public ModelAndView modifyPersonalInfo(MemberVO memberVO) {
		mav = new ModelAndView();
	
		int result = gitDAO.modifyPersonalInfo(memberVO);
		if(result == 0) {
			mav.setViewName("personalInfo");
		} else {
			mav.setViewName("main");
		}
		return mav;
	}

	//제품 검색시
	public ModelAndView searchingSth(String id, ItemVO itemVO) {
		mav = new ModelAndView();
		memberVO = new MemberVO();
		memberVO = gitDAO.searchingSth(id);
		
		
		SearchedInfo = gitDAO.searchingSth2(itemVO);
		mav.addObject("personalInfo", memberVO);
		mav.addObject("searchKeyword", SearchedInfo);
		
		mav.setViewName("searchingPage");
		
		return mav;
	}

	


}
