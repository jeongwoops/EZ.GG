package com.kh.ez.member.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ez.member.model.service.MemberService;
import com.kh.ez.member.model.vo.Friend;
import com.kh.ez.member.model.vo.Member;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


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
		String msg = null;

		try {
			if(result != null) {

				session.setAttribute("loginUser", result);
			} else {
				session.setAttribute("msg", "잘못된 아이디/비밀번호 입니다.");

			}
		}catch(Exception e) {
			session.setAttribute("msg", "로그인 중 예외 발생");
		}
		return "redirect:/";
	}


	
	@ResponseBody
	@RequestMapping(value="searchUser", produces="application/json;charset=UTF-8")
	public ArrayList<Member> searchUser(@RequestParam(value="nickName", defaultValue="") String nickName,Model model, HttpSession session) {
		
		ArrayList<Member> result = (ArrayList)mService.searchUser(nickName);
		
		try {
			if(result != null) {
			System.out.println("성공");
				
			} else {
				System.out.println("실패");
			}
		}catch(Exception e) {
			session.setAttribute("msg", "예외 발생");
		}
		return result;
	}
	
	@RequestMapping("addfriend")
	public String addFriend(Friend f, Model model, HttpSession session) {
		
		int result = mService.addFriend(f);
		
		try{
		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		}catch(Exception e) {
			session.setAttribute("msg", "친구추가 중 예외 발생");
		}
		return "redirect:/";
	}
	@RequestMapping("deleteFriend")
	public String deleteFriend(Friend f,Model model, HttpSession session) {
		
		int result = mService.deleteFriend(f);
		
		try{
		if(result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		}catch(Exception e) {
			session.setAttribute("msg", "회원가입 중 예외 발생");
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="flist", produces="application/json;charset=UTF-8")
	public List<Member> fList(Friend f,Model model, HttpSession session) {
		
		List<Member> result = mService.flist(f);
		
		try {
			if(result != null) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		}catch(Exception e) {
			session.setAttribute("msg", "로그인 중 예외 발생");
		}
		return result;
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
	@RequestMapping("createBo")
	public String createBoard() {
		return "views/createBoard";
	}

}

