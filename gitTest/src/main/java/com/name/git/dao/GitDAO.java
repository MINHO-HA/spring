package com.name.git.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.name.git.vo.MemberVO;

@Repository
public class GitDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int memberJoin(MemberVO memberVO) {
		return sqlSession.insert("Member.memberJoin", memberVO);
	}

	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Member.memberLogin", memberVO);
	}

	public MemberVO personalInfo(String id) {
		return sqlSession.selectOne("Member.personalInfo", id);
	}

	public int modifyPersonalInfo(MemberVO memberVO) {
		return sqlSession.update("Member.modifyPersonalInfo", memberVO);
	}


}
