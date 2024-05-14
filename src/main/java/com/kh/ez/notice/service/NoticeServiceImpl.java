package com.kh.ez.notice.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ez.notice.model.dao.NoticeDao;
import com.kh.ez.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private NoticeDao nDao;
	
	@Override
	public ArrayList<Notice> readNotice() {
		return nDao.readNotice();
	}
	@Override
	public int createNotice(Notice n) {
		return nDao.createNotice(n);
	}
	@Override
	public int increaseCount(int noticeNo) {
		return nDao.increaseCount(noticeNo);
	}
	
	
}
