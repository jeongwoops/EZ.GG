package com.kh.ez.board.model.dao;

import com.kh.ez.board.model.vo.Board;
import com.kh.ez.notice.model.vo.Notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class boardDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public int createBoard(Board b) {
        return sqlSession.insert("boardMapper.createBoard",b);
    }



    public int increaseCount(int boardNo) {
        return sqlSession.update("boardMapper.increaseCount",boardNo);
    }

    public ArrayList<Board> boardList() {
        return (ArrayList)sqlSession.selectList("boardMapper.boardList");
    }

    public Board boardView(Board b) {
        return sqlSession.selectOne("boardMapper.boardView", b);
    }
}
