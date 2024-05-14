package com.kh.ez.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.member.model.service.MemberService;
import com.kh.ez.member.model.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping("signUp")
	public String signUp(Member m,Model model, HttpSession session) {
		
		int result = mService.memberEnroll(m);
		
		try{
		if(result > 0) {
			session.setAttribute("msg","회원가입을 완료했습니다.");
		} else {
			session.setAttribute("msg","회원가입을 실패했습니다.");
		}
		}catch(Exception e) {
			session.setAttribute("msg", "회원가입 중 예외 발생");
		}
		return "redirect:/";
	}
	
	@RequestMapping("signIn")
	public String signIn(Member m,Model model, HttpSession session) {
		
		Member result = mService.memberLogin(m);
		
		try {
			if(result != null) {
				session.setAttribute("msg","환영합니다!");
				session.setAttribute("loginUser", result);
			} else {
				session.setAttribute("msg", "잘못된 아이디/비밀번호 입니다.");
			}
		}catch(Exception e) {
			session.setAttribute("msg", "로그인 중 예외 발생");
		}
		return "redirect:/";
	}
	
	
	@RequestMapping("enrollForm")
	public String enrollForm() {
		return "views/enrollForm";
	}
	
	@RequestMapping("loginPage")
	public String memberLogin() {
		return "views/loginPage";
	}
	
	
	@RequestMapping("logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		return "views/myPage";
	}
	
	
	@RequestMapping("createPrivateGame")
	public String createPrivateGame() {
		return "views/createPrivateGame";
	}
	
	@RequestMapping("afterGame")
	public String afterGame() {
		return "views/afterGame";
	}
	@RequestMapping("createNoti")
	public String createNotice() {
		return "views/createNotice";
	}
}

