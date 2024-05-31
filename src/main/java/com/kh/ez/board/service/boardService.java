package com.kh.ez.board.service;

import com.kh.ez.board.model.vo.Board;


import java.util.ArrayList;

public interface boardService {




    int createBoard(Board b);

    int increaseCount(int boardNo);

    ArrayList<Board> boardList();


    Board boardView(Board b);




}
