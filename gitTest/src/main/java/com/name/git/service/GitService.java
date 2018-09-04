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

	
	/*@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private HttpSession session;*/
	
	//회원가입 처리
	public ModelAndView memberJoin(MemberVO memberVO) {
		mav = new ModelAndView();
		int result = gitDAO.memberJoin(memberVO);
		if(result == 0) {
			mav.setViewName("signUp");
		} else {
			mav.setViewName("main");
		}
		return mav;
	}

	/*//로그인 처리
	public ModelAndView memberlogin(MemberVO memberVO, HttpServletResponse response) throws IOException {

		response.setContentType("text/thml; charset=UTF-8");
		mav = new ModelAndView();
		MemberVO loginMember = gitDAO.memberlogin(memberVO);
		PrintWriter out = response.getWriter();

		if(passEncoder.matches(memberVO.getMEM_PW(), loginMember.getMEM_PW())) {
			session.setAttribute("session_id", memberVO.getMEM_ID());
			mav.addObject("lgoinMember",loginMember);
			mav.setViewName("main"); // main.jsp or index.jsp
		} else {
			out.println("<script>"); // 로그인 실패 alert
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return mav;
	}*/



}
