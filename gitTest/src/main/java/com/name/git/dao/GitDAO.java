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

	public MemberVO memberlogin(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}



}
