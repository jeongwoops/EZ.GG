package com.kh.ez.pgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ez.pgame.model.dao.PgameDao;
import com.kh.ez.pgame.model.vo.Pgame;

@Service
public class PgameServiceImpl implements PgameService{

	@Autowired
	private PgameDao pDao;
	
	@Override
	public int afterGame(Pgame p) {
		return pDao.afterGame(p);
	}
	@Override
	public int calcInfo(String userNo) { //10전
		return pDao.calcInfo(userNo);
	}
	@Override
	public int calcInfo2(String userNo) {//7승
		return pDao.calcInfo2(userNo);
	}
	@Override
	public int calcInfo3(String userNo) {// 3패
		return pDao.calcInfo3(userNo);
	}
	@Override
	public int calcInfo4(String userNo) {//70퍼
		int total = pDao.calcInfo(userNo);
		int win = pDao.calcInfo2(userNo);
		
		return (int)(((double)win / total) * 100);  
	}
	@Override
	public double calcInfo5(String userNo ) {// 3.72
		int k = pDao.calcInfo5(userNo);
		int d = pDao.calcInfo6(userNo);
		int a = pDao.calcInfo7(userNo);
		double kda =((double)(k+a) / d);
		return Math.round(kda*100)/100.0;
	}
	@Override
	public int calcInfo6(String userNo ) {
		return pDao.calcInfo6( userNo);
	}
}
