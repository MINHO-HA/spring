package com.name.git.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.name.git.dao.GitDAO;
import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;

@Service
public class ItemService {
	
	@Autowired
	private GitDAO gitDAO;
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	private ItemVO itemVO;
	
	
	//제품 검색시
	public ModelAndView searchItem(String id, ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		
		memberVO = new MemberVO();
		memberVO = gitDAO.whenSearchingFollowingInfo(id);
		
		List<ItemVO> list = gitDAO.searchedResults(itemVO);
		
		modelAndView.addObject("personalInfo", memberVO);
		modelAndView.addObject("searchKeyword", list);
		modelAndView.setViewName("searchPage");
		
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
	public ModelAndView writeReview(ReviewVO reviewVO, HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = gitDAO.writeReview(reviewVO);
		
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


	//내가 작성한 리뷰 보기
	public ModelAndView reviewsIWrote(ReviewVO reviewVO) {

		modelAndView = new ModelAndView();
		
		List<ReviewVO> list = gitDAO.reviewsIWrote(reviewVO);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("reviewsIWrote");
		
		return modelAndView;
	}

}
