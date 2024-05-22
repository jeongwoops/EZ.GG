package com.kh.ez.pgame.service;

import com.kh.ez.pgame.model.PgameDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ez.pgame.model.dao.PgameDao;
import com.kh.ez.pgame.model.vo.Pgame;

import java.util.List;

@Slf4j
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

	@Override
	public String calcInfo7(String userNo) {
		int win = pDao.calcInfo2(userNo);
		int lose = pDao.calcInfo3(userNo);
		int pScore = (win * 25) - (lose * 25);
		String pTier = null;
		if (pScore < 100) {
			pTier = "Iron";
		} else if (pScore < 200) {
			pTier = "Bronze";
		} else if (pScore < 300) {
			pTier = "Silver";
		} else if (pScore < 400) {
			pTier = "Gold";
		} else if (pScore < 500) {
			pTier = "Platium";
		} else if (pScore < 600) {
			pTier = "Emerald";
		} else if (pScore < 700) {
			pTier = "Diamond";
		} else if (pScore < 800) {
			pTier = "Master";
		} else if (pScore < 900) {
			pTier = "GrandMaster";
		} else {
			pTier = "Challenger";
		}
		return pTier;
	}
	public String countPosition(String userNo) {
		int topCount = pDao.countPosition1(userNo);
		int jugCount = pDao.countPosition2(userNo);
		int midCount = pDao.countPosition3(userNo);
		int adcCount = pDao.countPosition4(userNo);
		int supCount = pDao.countPosition5(userNo);
		int[] pCount = {topCount, jugCount, midCount, adcCount, supCount};
		int max = pCount[0];
		int maxPos = 1;
		String mostPosition = null;

		for (int i = 0; i < pCount.length; i++) {
			if (max < pCount[i]) {
				max = pCount[i];
				maxPos = i + 1;
				System.out.println(max);
				System.out.println(maxPos);
				System.out.println(i);
			}
		}
				if (maxPos == 1) {
					mostPosition = "TOP";
				} else if (maxPos == 2) {
					mostPosition = "JUG";
				} else if (maxPos == 3) {
					mostPosition = "MID";
				} else if (maxPos == 4) {
					mostPosition = "ADC";
				} else if (maxPos == 5) {
					mostPosition = "SUP";
				}
		log.info(mostPosition);
		return mostPosition;
	}
	public List<PgameDto> calcInfo8(String userNo) {


		return pDao.calcInfo8(userNo);
	}
}
