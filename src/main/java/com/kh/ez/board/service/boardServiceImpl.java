package com.kh.ez.board.service;

import com.kh.ez.board.model.dao.boardDao;
import com.kh.ez.board.model.vo.Board;
import com.kh.ez.board.service.boardService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class boardServiceImpl implements boardService {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Autowired
    private boardDao bDao;


    @Override
    public int createBoard(Board b) {
        return bDao.createBoard(b);
    }
    @Override
    public int increaseCount(int BoardNo) {
        return bDao.increaseCount(BoardNo);
    }
    @Override
    public ArrayList<Board> boardList() {
        ArrayList<Board> boardList = bDao.boardList();
        return boardList;
    }
    @Override
    public Board boardView(Board b) {
        return bDao.boardView(b);
    }




}
