package com.name.git.service;








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

	



}
