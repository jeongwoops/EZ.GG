package com.kh.ez.member.model.service;

import com.kh.ez.member.model.vo.Member;

public interface MemberService {

	int memberEnroll(Member m);

	Member memberLogin(Member m);

}
