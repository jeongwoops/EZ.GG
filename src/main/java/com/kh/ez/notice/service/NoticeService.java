package com.kh.ez.notice.service;

import java.util.ArrayList;

import com.kh.ez.notice.model.vo.Notice;

public interface NoticeService {

	
	
	int createNotice(Notice n);

	int increaseCount(int noticeNo);

	ArrayList<Notice> noticeList();


	Notice noticeView(Notice n);
}
