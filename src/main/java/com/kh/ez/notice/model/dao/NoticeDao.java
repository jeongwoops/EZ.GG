package com.kh.ez.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ez.notice.model.vo.Notice;

@Repository
public class NoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int createNotice(Notice n) {
		return sqlSession.insert("noticeMapper.createNotice",n);
	}

	public int increaseCount(int noticeNo) {
		return sqlSession.update("noticeMapper.increaseCount",noticeNo);
	}

	public ArrayList<Notice> noticeList() {
		return (ArrayList)sqlSession.selectList("noticeMapper.noticeList");
	}

	public Notice noticeView(Notice n) {
		return sqlSession.selectOne("noticeMapper.noticeView", n);
	}
}
