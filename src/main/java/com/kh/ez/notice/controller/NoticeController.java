package com.kh.ez.notice.controller;

import java.util.ArrayList;

import com.kh.ez.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ez.notice.model.vo.Notice;
import com.kh.ez.notice.service.NoticeService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;

	
	@RequestMapping("notice")
	public String notice(Model model, HttpSession session) {
		log.info(">>>>>>>>>>>>>>>>>>>> notice");

		ArrayList<Notice> nList = nService.noticeList();
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
		
		
		
		ArrayList<Notice> nList = nService.noticeList();
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
			return "nList";
		}
	@RequestMapping("createNotice")
	public String readNotice(Notice n, Model model, HttpSession session) {

		String nickName = ((Member)session.getAttribute("loginUser")).getNickName();
		n.setWriter(nickName);
		int result = nService.createNotice(n);
		
		try{
			if(result > 0) {
				session.setAttribute("msg"," 완료했습니다.");
				session.setAttribute("nContent",result);

			} else {
				session.setAttribute("msg"," 실패했습니다.");
			}
		} catch(Exception e) {
			session.setAttribute("msg", " 예외 발생");
		}
		return "redirect:/";
	}
	@RequestMapping("noticeView")
	public String noticeView() {
		return "views/noticeView";
	}

	@RequestMapping("noticeDetail")
	public String getNoticeDetail(@RequestParam String no, Model model) {
		Notice n = new Notice();
		n.setNoticeNo(Integer.parseInt(no));

		// 조회 전 조회수 증가
		nService.increaseCount(n.getNoticeNo());

		// DB에서 no에 해당하는 공지사항 정보 조회
		Notice result = nService.noticeView(n);

		try {
			if (result != null) {
				model.addAttribute("n", result);
			}else{

			}
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "views/noticeView";
	}



	@ResponseBody
	@RequestMapping(value="noticeList", produces="application/json;charset=UTF-8")
	public ArrayList<Notice> noticeList(HttpSession session, Model model) {
		ArrayList<Notice> noticeList = new ArrayList<>();

		try{
			if(noticeList != null) {
				noticeList = nService.noticeList();
				log.info("게시글 개수 : {}", noticeList);
				model.addAttribute("n", noticeList);
			} else {

			}
		}catch(Exception e) {
			session.setAttribute("msg", " 예외 발생");
		}

		return noticeList;
	}
}
