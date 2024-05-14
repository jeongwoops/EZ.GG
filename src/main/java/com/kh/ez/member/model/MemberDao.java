package com.kh.ez.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ez.member.model.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int memberEnroll(Member m) {
		return sqlSession.insert("memberMapper.signUp",m);
	}
	
	public Member memberLogin(Member m) {
		return sqlSession.selectOne("memberMapper.signIn",m);
	}
	

}
