package com.kh.ez.member.model.vo;

public class Member {

	private int userNo;
	private String nickName;
	private String userId;
	private String userPw;
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", nickName=" + nickName + ", userId=" + userId + ", userPw=" + userPw
				+ "]";
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public Member(int userNo, String nickName, String userId, String userPw) {
		super();
		this.userNo = userNo;
		this.nickName = nickName;
		this.userId = userId;
		this.userPw = userPw;
	}
	public Member() {
		super();
	}
}
