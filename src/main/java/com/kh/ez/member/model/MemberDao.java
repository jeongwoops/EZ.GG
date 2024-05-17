package com.kh.ez.member.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ez.member.model.vo.Friend;
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

	

	public List<Member> searchUser(String nickName) {
		return (List)sqlSession.selectList("memberMapper.searchUser",nickName);
	}

	public int addFriend(Friend f) {
		return sqlSession.insert("memberMapper.addFriend",f);
	}

	public List<Member> flist(Friend f) {
		return (List)sqlSession.selectList("memberMapper.flist",f);
	}

	public int deleteFriend(Friend f) {
		return sqlSession.delete("memberMapper.deleteFriend",f);
	}

	public Member selectUserByUserNo(String userNo){
		return  sqlSession.selectOne("memberMapper.selectUserByUserNo",userNo);
	}

}
	


