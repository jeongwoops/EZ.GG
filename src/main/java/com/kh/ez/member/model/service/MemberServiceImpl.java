package com.kh.ez.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ez.member.model.MemberDao;
import com.kh.ez.member.model.vo.Friend;
import com.kh.ez.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao mDao;


	
	@Override
	public int memberEnroll(Member m) {
		return mDao.memberEnroll(m);
	}
	@Override
	public Member memberLogin(Member m) {
		Member loginUser = mDao.memberLogin(m);
		return loginUser;
	}
	@Override
	public int addFriend(Friend f) {
		return mDao.addFriend(f);
	}
	@Override
	public List<Member> searchUser(String nickName) {
		return mDao.searchUser(nickName);
	}
	@Override
	public List<Member> flist(Friend f) {
		List<Member> friends = mDao.flist(f);
		return friends;
	}
	@Override
	public int deleteFriend(Friend f) {
		return mDao.deleteFriend(f);
	}

	@Override
	public Member selectUserByUserNo(String userNo) {
		return mDao.selectUserByUserNo(userNo);
	}
}
