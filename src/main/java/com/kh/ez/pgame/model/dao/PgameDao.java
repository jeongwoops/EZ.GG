package com.kh.ez.pgame.model.dao;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.PgameDto;
import com.kh.ez.pgame.model.vo.Champion;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ez.pgame.model.vo.Pgame;

import java.util.List;

@Repository
public class PgameDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int afterGame(Pgame p) {
	
		return sqlSession.insert("pgameMapper.insertPrivateGame",p);
	}
	public int calcInfo(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.selectPgameCount",userNo);
		
	}
	public int calcInfo2(String userNo) {
			
			return sqlSession.selectOne("pgameMapper.selectPgameWinCount",userNo);
			
		}
	public int calcInfo3(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.selectPgameLoseCount",userNo);
		
	}
//
	public int calcInfo5(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.selectKillCount",userNo);
		
	}
	public int calcInfo6(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.selectDeathCount",userNo);
		
	}
	public int calcInfo7(String userNo) {
			
			return sqlSession.selectOne("pgameMapper.selectAssistCount",userNo);
			
		}
	public int countPosition1(String userNo){
		return sqlSession.selectOne("pgameMapper.topcount",userNo);
	}
	public int countPosition2(String userNo){
		return sqlSession.selectOne("pgameMapper.jugcount",userNo);
	}
	public int countPosition3(String userNo){
		return sqlSession.selectOne("pgameMapper.midcount",userNo);
	}
	public int countPosition4(String userNo){
		return sqlSession.selectOne("pgameMapper.adccount",userNo);
	}
	public int countPosition5(String userNo){
		return sqlSession.selectOne("pgameMapper.supcount",userNo);
	}

	public List<PgameDto> calcInfo8(String userNo) {
		return (List)sqlSession.selectList("pgameMapper.selectPgameInfoByUserNo", userNo);
	}

	public int getGameCountByNickName (Member m){
		return sqlSession.selectOne("pgameMapper.getGameCountByNickName" , m);
	}
	public int getWinCountByNickName (Member m){
		return sqlSession.selectOne("pgameMapper.getWinCountByNickName" , m);
	}
	public List<Champion> getChampionList(){
		return sqlSession.selectList("pgameMapper.getChampionList");
	}
}
