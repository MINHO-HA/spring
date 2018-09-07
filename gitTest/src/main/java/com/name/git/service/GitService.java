package com.name.git.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.dao.GitDAO;
import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;

@Service
public class GitService {
	
	@Autowired
	private GitDAO gitDAO;
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	private ItemVO itemVO;
	
	
	@Autowired
	private HttpSession session;
	
	
	
	//회원가입 처리
	public ModelAndView memberJoin(MemberVO memberVO) {
		
		modelAndView = new ModelAndView();

		int result = gitDAO.memberJoin(memberVO);
		
		if(result == 0) {
			modelAndView.setViewName("signUp");
		} else {
			modelAndView.setViewName("main");
		}
		
		return modelAndView;
	}

	
	
	//개인정보 페이지 비밀번호 확인
	public ModelAndView passwordChecking(MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberVO password = gitDAO.passwordChecking(memberVO);

		if(memberVO.getMEM_PW().equals(password.getMEM_PW())) {
			modelAndView.addObject("check", memberVO);
			modelAndView.setViewName("myPage");
		} else { 
			out.println("<script>"); 
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		return modelAndView;
	}
	
	
	
	//로그인 처리
	public ModelAndView memberLogin(MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberVO loginMember = gitDAO.memberLogin(memberVO);
	
		if(memberVO.getMEM_PW().equals(loginMember.getMEM_PW())) {
			session.setAttribute("session_id", memberVO.getMEM_ID());
			modelAndView.setViewName("main");
		} else {
			// 로그인 실패 alert
			out.println("<script>"); 
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		return modelAndView;
	}

	
	
	//개인정보 보기
	public ModelAndView personalInfo(String id) {
		
		modelAndView = new ModelAndView();
		
		memberVO = new MemberVO();
		memberVO = gitDAO.personalInfo(id);
		
		modelAndView.addObject("personalInfo", memberVO);
		modelAndView.setViewName("personalInfo");
	
		return modelAndView;
	}

	
	
	//개인정보 변경
	public ModelAndView modifyPersonalInfo(MemberVO memberVO) {
		
		modelAndView = new ModelAndView();
	
		int result = gitDAO.modifyPersonalInfo(memberVO);
		
		if(result == 0) {
			modelAndView.setViewName("personalInfo");
		} else {
			modelAndView.setViewName("main");
		}
		
		return modelAndView;
	}

	
	
	//제품 검색시
	public ModelAndView searchingKeyword(String id, ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		
		memberVO = new MemberVO();
		memberVO = gitDAO.whenSearchingFollowingInfo(id);
		
		List<ItemVO> list = gitDAO.searchedResults(itemVO);
		
		modelAndView.addObject("personalInfo", memberVO);
		modelAndView.addObject("searchKeyword", list);
		modelAndView.setViewName("searchingPage");
		
		return modelAndView;
	}
	
	
	
	//제품 상세페이지
	public ModelAndView viewItem(ReviewVO reviewVO) {
		
		modelAndView = new ModelAndView();
		
		itemVO = new ItemVO();
		itemVO = gitDAO.viewItem(reviewVO);
		
		List<ReviewVO> list = gitDAO.reviewLists(reviewVO);
		modelAndView.addObject("reviewLists", list);
		
		modelAndView.addObject("itemView", itemVO);
		modelAndView.setViewName("viewItem");
		
		return modelAndView;
	}


	//리뷰 작성
	public ModelAndView reviewWriting(ReviewVO reviewVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = gitDAO.reviewWriting(reviewVO);
		
		if(result == 0) {
			out.println("<script>"); 
			out.println("alert('리뷰작성에 실패하였습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else {
			//리뷰변수 넣어야되고
			//쿼리문에서 충분한 벨류값 넣어야되고 
			modelAndView.setViewName("redirect:/viewItem?ITEM_ID="+reviewVO.getITEM_ID()+"&MEM_ID="+reviewVO.getMEM_ID());
		}
		
		return modelAndView;
	}

}
