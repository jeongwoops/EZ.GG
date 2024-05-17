package com.kh.ez.member.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.ez.member.model.vo.Friend;
import com.kh.ez.member.model.vo.Member;

public interface MemberService {

	int memberEnroll(Member m);

	Member memberLogin(Member m);

	

	List<Member> searchUser(String nickName);

	int addFriend(Friend f);

	List<String>  flist(Friend f);


	



}
