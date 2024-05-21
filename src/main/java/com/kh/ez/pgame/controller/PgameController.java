package com.kh.ez.pgame.controller;

import com.kh.ez.member.model.service.MemberService;
import com.kh.ez.member.model.vo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.vo.Pgame;
import com.kh.ez.pgame.service.PgameService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class PgameController {
	
	@Autowired
	private PgameService pService;
	@Autowired
	private MemberService mService;


	@RequestMapping("after")
	public String after(Pgame p, Model model, HttpSession session) {
		
		int result = pService.afterGame(p);
		
		try{
			if(result > 0) {
				session.setAttribute("msg"," 업데이트 완료했습니다.");
			} else {

			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "redirect:/";
		}
	
	@RequestMapping("privateGameInfo")
	public String privateGameInfo( Model model, HttpSession session) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		log.info("{}",loginUser);
		int result = pService.calcInfo(loginUser.getUserNo()+"");
		int result2 = pService.calcInfo2(loginUser.getUserNo()+"");
		int result3 = pService.calcInfo3(loginUser.getUserNo()+"");
		int result4 = pService.calcInfo4(loginUser.getUserNo()+"");
		double result5= pService.calcInfo5(loginUser.getUserNo()+"");
		String result7 = pService.calcInfo7(loginUser.getUserNo()+"");
		String result8 = pService.countPosition(loginUser.getUserNo()+"");
		try{
			log.info("{}",result4);
			if(result > 0) {


				model.addAttribute("pcount", result);
				model.addAttribute("pgame_win", result2);
				model.addAttribute("pgame_lose", result3);
				model.addAttribute("pgame_winrate", result4);
				model.addAttribute("pgame_kda", result5);
				model.addAttribute("pTier", result7);
				model.addAttribute("pMostPosition", result8);
			} else {

			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
		return "views/privateGameInfo";
	}
	@RequestMapping("viewFriendInfo")
	public String viewFriendInfo( Friend friend, Model model, HttpSession session) {

		Member user = mService.selectUserByUserNo(String.valueOf(friend.getFriendNo()));
		int result = pService.calcInfo(friend.getFriendNo() + "");
		int result2 = pService.calcInfo2(friend.getFriendNo() + "");
		int result3 = pService.calcInfo3(friend.getFriendNo() + "");
		int result4 = pService.calcInfo4(friend.getFriendNo() + "");
		double result5 = pService.calcInfo5(friend.getFriendNo() + "");
			try {
				log.info("{}", result4);
				if (result > 0) {


					model.addAttribute("pcount", result);
					model.addAttribute("pgame_win", result2);
					model.addAttribute("pgame_lose", result3);
					model.addAttribute("pgame_winrate", result4);
					model.addAttribute("pgame_kda", result5);
					model.addAttribute("nickName", user.getNickName());

				} else {

				}
			} catch (Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "views/viewFriendInfo";

	}
}
