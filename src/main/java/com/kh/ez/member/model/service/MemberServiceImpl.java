package com.kh.ez.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ez.member.model.MemberDao;
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
	
	
}
