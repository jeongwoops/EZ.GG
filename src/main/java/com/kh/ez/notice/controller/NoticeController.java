package com.kh.ez.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.notice.model.vo.Notice;
import com.kh.ez.notice.service.NoticeService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;

	
	@RequestMapping("notice")
	public String notice(Model model, HttpSession session) {
		log.info(">>>>>>>>>>>>>>>>>>>> notice");
		
//		int count = nService.increaseCount();
		ArrayList<Notice> nList = nService.readNotice();
		try{
			log.info("게시글 개수 : {}", nList);
			if(nList.size() > 0) {

				session.setAttribute("newNotice",nList);
				model.addAttribute("list",nList);
//				model.addAttribute("list",count);
			} else {
				System.out.print("실패");
			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}	
		
		return "views/notice";
	}
	
	@RequestMapping("readNotice")
	public String createNotice(Notice n, Model model, HttpSession session) {
		
		
		
		ArrayList<Notice> nList = nService.readNotice();
		try{
			log.info("게시글 개수 : {}", nList);
			if(nList.size() > 0) {
				session.setAttribute("msg"," 완료했습니다.");
				session.setAttribute("newNotice",nList);
				model.addAttribute("list",nList);
			} else {
				session.setAttribute("msg"," 실패했습니다.");
			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "redirect:/";
		}
	@RequestMapping("createNotice")
	public String readNotice(Notice n, Model model, HttpSession session) {
		
		int result = nService.createNotice(n);
		
		try{
			if(result > 0) {
				session.setAttribute("msg"," 완료했습니다.");
				session.setAttribute("nContent",result);
			} else {
				session.setAttribute("msg"," 실패했습니다.");
			}
			}catch(Exception e) {
				session.setAttribute("msg", " 예외 발생");
			}
			return "redirect:/";
		}
	@RequestMapping("noticeView")
	public String noticeView() {
		return "views/noticeView";
	}
	
}
