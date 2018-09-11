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
import com.name.git.vo.LikedVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;
import com.name.git.vo.SelectedVO;

@Service
public class ItemService {
	
	@Autowired
	private GitDAO gitDAO;
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	private ItemVO itemVO;
	private LikedVO likedVO;
	private SelectedVO selectedVO;
	
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


	//좋아요 올리기
	public ModelAndView raiseLike(ReviewVO reviewVO, LikedVO likedVO,HttpServletResponse response) throws IOException {
		
		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = gitDAO.raiseLike(reviewVO);
		
		if(result == 0) {
			out.println("<script>"); 
			out.println("alert('좋아요 올리기 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else {
			gitDAO.raiseLike2(likedVO);
			modelAndView.setViewName("redirect:/viewItem?ITEM_ID="+reviewVO.getITEM_ID());
		}
		
		return modelAndView;
	}


	//내가 좋아요한 리뷰 보기 (해당 아이디 REVIEW_ID 값 구하기)
	public ModelAndView reviewsILiked(String id) {


		modelAndView = new ModelAndView();
		
		likedVO = new LikedVO();
		likedVO = gitDAO.reviewsILiked(id);
		
		List<ReviewVO> list = gitDAO.reviewsILiked2(likedVO.getREVIEW_ID());
		modelAndView.addObject("list", list);
		modelAndView.setViewName("reviewsILiked");
		
		return modelAndView;
	}


	//찜하기
	public ModelAndView markItem(SelectedVO selectedVO, HttpServletResponse response) throws IOException {

		modelAndView = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = gitDAO.markItem(selectedVO);
		
		if(result == 0) {
			out.println("<script>");
			out.println("alert('찜 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else {
			modelAndView.setViewName("redirect:/viewItem?ITEM_ID="+selectedVO.getITEM_ID());
		}
		
		return modelAndView;
	}


	//내가 찜한 목록 보기
	public ModelAndView listsIMarked(String id) {
		
		modelAndView = new ModelAndView();
		
		selectedVO = new SelectedVO();
		selectedVO = gitDAO.listsIMarked(id);
		
		List<ItemVO> list = gitDAO.listsIMarked2(selectedVO.getITEM_ID());
		modelAndView.addObject("list", list);
		modelAndView.setViewName("listsIMarked");
		
		return modelAndView;
	}





}
