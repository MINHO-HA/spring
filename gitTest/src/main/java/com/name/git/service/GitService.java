package com.name.git.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.dao.GitDAO;
import com.name.git.vo.MemberVO;

@Service
public class GitService {
	
	@Autowired
	private GitDAO gitDAO;
	private ModelAndView mav;
	
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
			out.println("<script>"); // 로그인 실패 alert
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return mav;
	}


}
