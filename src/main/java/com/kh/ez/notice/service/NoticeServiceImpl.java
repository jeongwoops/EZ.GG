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
	public int createNotice(Notice n) {
		return nDao.createNotice(n);
	}
	@Override
	public int increaseCount(int noticeNo) {

		return nDao.increaseCount(noticeNo);

	}
	@Override
	public ArrayList<Notice> noticeList() {
		ArrayList<Notice> noticeList = nDao.noticeList();
		return noticeList;
		}
	@Override
	public Notice noticeView(Notice n) {
		return nDao.noticeView(n);
	}

	
}
