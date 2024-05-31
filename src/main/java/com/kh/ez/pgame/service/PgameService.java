package com.kh.ez.pgame.service;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.PgameDto;
import com.kh.ez.pgame.model.vo.Champion;
import com.kh.ez.pgame.model.vo.Pgame;

import java.util.List;

public interface PgameService {

	int afterGame(Pgame p);

	

	int calcInfo(String userNo);
	int calcInfo2(String userNo);
	int calcInfo3(String userNo);
	int calcInfo4(String userNo);
	double calcInfo5(String userNo);
	int calcInfo6(String userNo);
	String countPosition(String userNo);

    String calcInfo7(String userNo);

	List<PgameDto> calcInfo8(String userNo);

	int getWinrate(Member m);

	int getSumWinrate(Member m);

	List<Champion> getChampionList();
}
