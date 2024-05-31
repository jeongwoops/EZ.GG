package com.kh.ez.board.controller;

import com.kh.ez.board.model.vo.Board;

import com.kh.ez.board.service.boardService;
import com.kh.ez.notice.model.vo.Notice;
import com.kh.ez.notice.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Slf4j
@Controller
public class boardController {

    @Autowired
    private boardService bService;


    @RequestMapping("board")
    public String Board(Model model, HttpSession session) {


//		int count = bService.increaseCount();
        ArrayList<Board> bList = bService.boardList();
        try{

            if(bList.size() > 0) {

                session.setAttribute("newNotice",bList);
                model.addAttribute("list",bList);
//				model.addAttribute("list",count);
            } else {
                System.out.print("실패");
            }
        }catch(Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", " 예외 발생");
        }

        return "views/board";
    }

    @RequestMapping("readboard")
    public String createNotice(Board b, Model model, HttpSession session) {



        ArrayList<Board> bList = bService.boardList();
        try{

            if(bList.size() > 0) {
                session.setAttribute("msg"," 완료했습니다.");
                session.setAttribute("newboard",bList);
                model.addAttribute("list",bList);
            } else {
                session.setAttribute("msg"," 실패했습니다.");
            }
        }catch(Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", " 예외 발생");
        }
        return "bList";
    }
    @RequestMapping("createBoard")
    public String readboard(Board b, Model model, HttpSession session) {

        int result = bService.createBoard(b);

        try{
            if(result > 0) {
                session.setAttribute("msg"," 완료했습니다.");
                session.setAttribute("bContent",result);
            } else {
                session.setAttribute("msg"," 실패했습니다.");
            }
        } catch(Exception e) {
            session.setAttribute("msg", " 예외 발생");
        }
        return "redirect:/board";
    }
    @RequestMapping("boardView")
    public String boardView() {
        return "views/boardView";
    }

    @RequestMapping("boardDetail")
    public String getNoticeDetail(@RequestParam String no, Model model) {
        Board b = new Board();
        b.setBoardNo(Integer.parseInt(no));

        bService.increaseCount(Integer.parseInt(no));
        // DB에서 no에 해당하는 공지사항 정보 조회
        Board result = bService.boardView(b);

        try {
            if (result != null) {
                model.addAttribute("b", result);
            }else{

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "views/boardView";
    }



    @ResponseBody
    @RequestMapping(value="boardList", produces="application/json;charset=UTF-8")
    public ArrayList<Board> boardList(HttpSession session, Model model) {
        ArrayList<Board> boardList = new ArrayList<>();

        try{
            if(boardList != null) {
                boardList = bService.boardList();
                log.info("게시글 개수 : {}", boardList);
                model.addAttribute("b", boardList);
            } else {

            }
        }catch(Exception e) {
            session.setAttribute("msg", " 예외 발생");
        }

        return boardList;
    }
}
