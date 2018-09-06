package com.name.git.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.name.git.vo.ItemVO;
import com.name.git.vo.MemberVO;

@Repository
public class GitDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int memberJoin(MemberVO memberVO) {
		return sqlSession.insert("Git.memberJoin", memberVO);
	}

	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Git.memberLogin", memberVO);
	}

	public MemberVO personalInfo(String id) {
		return sqlSession.selectOne("Git.personalInfo", id);
	}

	public int modifyPersonalInfo(MemberVO memberVO) {
		return sqlSession.update("Git.modifyPersonalInfo", memberVO);
	}

	public MemberVO passwordChecking(MemberVO memberVO) {
		return sqlSession.selectOne("Git.passwordChecking", memberVO);
	}

	public MemberVO searchingSth(String id) {
		return sqlSession.selectOne("Git.whenSearchingFollowingInfo", id);
	}

	public List<ItemVO> searchingSth2(ItemVO itemVO) {
		return sqlSession.selectList("Git.searchKeyword", itemVO);
	}

	public ItemVO viewItem(int id) {
		return sqlSession.selectOne("Git.viewItem", id);
	}
	
	


}
