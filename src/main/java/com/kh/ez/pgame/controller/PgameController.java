package com.kh.ez.pgame.controller;

import com.kh.ez.member.model.service.MemberService;
import com.kh.ez.member.model.vo.Friend;
import com.kh.ez.notice.model.vo.Notice;
import com.kh.ez.pgame.model.PgameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.vo.Pgame;
import com.kh.ez.pgame.service.PgameService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.Collections.list;

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

	@RequestMapping("afterGame")
	public String afterGame(Model model) {

		  model.addAttribute("champList",pService.getChampionList());
		return "views/afterGame";

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
		List<PgameDto> result9 = pService.calcInfo8(loginUser.getUserNo()+"");
		String result10 = pService.countChampion(loginUser.getUserNo()+"");

		log.info("{}",result10);
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
				model.addAttribute("pRecord", result9);
				model.addAttribute("pMostChampion",result10);

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
		String result7 = pService.calcInfo7(friend.getFriendNo()+"");
		String result8 = pService.countPosition(friend.getFriendNo()+"");
		List<PgameDto> result9 = pService.calcInfo8(friend.getFriendNo()+"");
		String result10 = pService.countChampion(friend.getFriendNo()+"");

			try {
				log.info("{}", result4);
				if (result > 0) {


					model.addAttribute("pcount", result);
					model.addAttribute("pgame_win", result2);
					model.addAttribute("pgame_lose", result3);
					model.addAttribute("pgame_winrate", result4);
					model.addAttribute("pgame_kda", result5);
					model.addAttribute("nickName", user.getNickName());
					model.addAttribute("pTier", result7);
					model.addAttribute("pMostPosition", result8);
					model.addAttribute("pRecord", result9);
					model.addAttribute("pMostChampion",result10);

				} else {

				}
			} catch (Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "views/viewFriendInfo";

	}
	@ResponseBody
	@RequestMapping("winrate/user")
	public int getWinrate(Member m) {


		List<Member> user = mService.searchUserByNickName(m.getNickName());

		if (user.size() == 0)  {
			return -1;
		}

		int result = 0;
		result = pService.getWinrate(m);

        return result;
    }
	@RequestMapping("team")
	public List<Member>setTeam(Member m) {
		List<Member> list = mService.searchUser(m.getNickName());
		return list;
	}
//@ResponseBody
//@RequestMapping("sumWinrate/user")
//public int sumWinrate(Member m) {
//	List<Member> list = mService.searchUser(m.getNickName());
//
//	if (list.isEmpty()) {
//		return -1;
//	}else {
//
//		int result = 0;
//
//		result = pService.getSumWinrate(m);
//		for (int i = 0; i < list.size(); i++) {
//            result = result.Winrate(i);
//		}
//	}
//	return result;
//	}


}

