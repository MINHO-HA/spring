package com.name.git.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;
import com.name.git.vo.ReviewVO;

@Repository
public class GitDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//회원가입 처리
	public int memberJoin(MemberVO memberVO) {
		return sqlSession.insert("Git.memberJoin", memberVO);
	}
	
	
	//로그인 처리
	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Git.memberLogin", memberVO);
	}
	
	
	//개인정보 보기
	public MemberVO personalInfo(String id) {
		return sqlSession.selectOne("Git.personalInfo", id);
	}
	
	
	//개인정보 수정
	public int modifyPersonalInfo(MemberVO memberVO) {
		return sqlSession.update("Git.modifyPersonalInfo", memberVO);
	}
	
	
	//개인정보 보기 전 비밀번호입력 처리
	public MemberVO passwordChecking(MemberVO memberVO) {
		return sqlSession.selectOne("Git.passwordChecking", memberVO);
	}
	
	
	//검색시 따라오는 개인정보 처리
	public MemberVO whenSearchingFollowingInfo(String id) {
		return sqlSession.selectOne("Git.whenSearchingFollowingInfo", id);
	}
	
	
	//검색 결과 처리
	public List<ItemVO> searchedResults(ItemVO itemVO) {
		return sqlSession.selectList("Git.searchedResults", itemVO);
	}
	
	
	//제품 상세 페이지 처리
	public ItemVO viewItem(ReviewVO reviewVO) {
		return sqlSession.selectOne("Git.viewItem", reviewVO);
	}


	//리뷰 작성 처리
	public int writeReview(ReviewVO reviewVO) {
		return sqlSession.insert("Git.writeReview", reviewVO);
	}

	//리뷰 목록 보기
	public List<ReviewVO> reviewLists(ReviewVO reviewVO) {
		return sqlSession.selectList("Git.reviewLists", reviewVO);
	}
	
	
}
