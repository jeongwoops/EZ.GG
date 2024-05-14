package com.kh.ez.pgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.vo.Pgame;
import com.kh.ez.pgame.service.PgameService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PgameController {
	
	@Autowired
	private PgameService pService;
	
	@RequestMapping("after")
	public String after(Pgame p, Model model, HttpSession session) {
		
		int result = pService.afterGame(p);
		
		try{
			if(result > 0) {
				session.setAttribute("msg"," 완료했습니다.");
			} else {
				session.setAttribute("msg"," 실패했습니다.");
			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "redirect:/";
		}
	
	@RequestMapping("privateGameInfo")
	public String privateGameInfo( Model model, HttpSession session) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int result = pService.calcInfo(loginUser.getUserNo()+"");
		int result2 = pService.calcInfo2(loginUser.getUserNo()+"");
		int result3 = pService.calcInfo3(loginUser.getUserNo()+"");
		int result4 = pService.calcInfo4(loginUser.getUserNo()+"");
		double result5= pService.calcInfo5(loginUser.getUserNo()+"");
		try{
			log.info("{}",result4);
			if(result > 0) {
				session.setAttribute("msg"," 완료했습니다.");
				session.setAttribute("pcount", result);
				session.setAttribute("pgame_win", result2);
				session.setAttribute("pgame_lose", result3);
				session.setAttribute("pgame_winrate", result4);
				session.setAttribute("pgame_kda", result5);

			} else {
				session.setAttribute("msg"," 실패했습니다.");
			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
		return "views/privateGameInfo";
	}
	
}
