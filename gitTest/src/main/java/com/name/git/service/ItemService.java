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
	private ItemVO itemVO2;
	private LikedVO likedVO;
	private SelectedVO selectedVO;
	private ReviewVO reviewVO;
	private MemberVO memberVO;
	
	
	//제품 검색시
	public ModelAndView searchItem(ItemVO itemVO) {
		
		modelAndView = new ModelAndView();
		
		List<ItemVO> list = gitDAO.searchedResults(itemVO);
		
		modelAndView.addObject("searchKeyword", list);
		modelAndView.setViewName("searchPage");
		
		return modelAndView;
	}
	
	//검색 필터 처리
	public ModelAndView searchFilter(ItemVO itemVO,HttpServletResponse response) throws IOException {
		
		
		response.setContentType("text/html; charset=UTF-8");
		modelAndView = new ModelAndView();
		
		
		if(itemVO.getGENDER_ID() == 1 || itemVO.getGENDER_ID() == 2) {
			itemVO2 = gitDAO.searchFilter(itemVO);
		} else if(itemVO.getAGE_ID() != 0){
			itemVO2 = gitDAO.searchFilter2(itemVO);
		} else if(itemVO.getSKINTYPE_ID() != 0) {
			itemVO2 = gitDAO.searchFilter3(itemVO);
		}
		
		System.out.println("==========");
		System.out.println("성별번호 : "+itemVO2.getGENDER_ID());
		System.out.println("나이번호 : "+itemVO2.getAGE_ID());
		System.out.println("스킨번호 : "+itemVO2.getSKINTYPE_ID());
		System.out.println("검색어 : "+itemVO2.getITEM_NAME());
		System.out.println("==========");
		
		modelAndView.setViewName("redirect:/searchItem?ITEM_CATEGORY="+itemVO2.getITEM_CATEGORY()+"&ITEM_NAME="+itemVO2.getITEM_NAME());
		
		return modelAndView;
	}

	//제품 상세페이지
	public ModelAndView viewItem(ReviewVO reviewVO) {
		
		modelAndView = new ModelAndView();
		
		itemVO2 = new ItemVO();
		itemVO2 = gitDAO.viewItem(reviewVO);
		
		List<ReviewVO> list = gitDAO.reviewLists(reviewVO);
		modelAndView.addObject("reviewLists", list);
		
		modelAndView.addObject("itemView", itemVO2);
		modelAndView.setViewName("itemDetail");
		
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
		modelAndView.setViewName("myPageReviewWrote");
		
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
		
		System.out.println("=========================");
		System.out.println("====================="+likedVO.getREVIEW_ID());
		System.out.println("=========================");
		List<ReviewVO> list = gitDAO.reviewsILiked2(likedVO.getREVIEW_ID());
		modelAndView.addObject("list", list);
		modelAndView.setViewName("myPageReviewLiked");
		
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
		modelAndView.setViewName("myPageItemStored");
		
		return modelAndView;
	}

	//리뷰 상세보기
	public ModelAndView viewReview(int id) {
		
		modelAndView = new ModelAndView();
		
		reviewVO = new ReviewVO();
		reviewVO = gitDAO.viewReview(id);
		memberVO = gitDAO.viewMemInfo(reviewVO.getMEM_ID());
		
		modelAndView.addObject("viewReview", reviewVO);
		modelAndView.addObject("memInfo", memberVO);
		modelAndView.setViewName("reviewDetail");
		
		return modelAndView;
	}

}
