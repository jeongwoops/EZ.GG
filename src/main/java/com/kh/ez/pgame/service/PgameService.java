package com.kh.ez.pgame.service;

import com.kh.ez.pgame.model.vo.Pgame;

public interface PgameService {

	int afterGame(Pgame p);

	

	int calcInfo(String userNo);
	int calcInfo2(String userNo);
	int calcInfo3(String userNo);
	int calcInfo4(String userNo);
	double calcInfo5(String userNo);
	int calcInfo6(String userNo);
	

}
