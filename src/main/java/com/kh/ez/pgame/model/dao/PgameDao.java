package com.kh.ez.pgame.model.dao;

import com.kh.ez.member.model.vo.Member;
import com.kh.ez.pgame.model.PgameDto;
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
	
		return sqlSession.insert("pgameMapper.after",p);
	}
	public int calcInfo(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.calc1",userNo);
		
	}
	public int calcInfo2(String userNo) {
			
			return sqlSession.selectOne("pgameMapper.calc2",userNo);
			
		}
	public int calcInfo3(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.calc3",userNo);
		
	}
//	public int calcInfo4(String userNo) {
//		
//		return sqlSession.selectList("pgameMapper.calc4",userNo);
//		
//	}
	public int calcInfo5(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.calc5",userNo);
		
	}
	public int calcInfo6(String userNo) {
		
		return sqlSession.selectOne("pgameMapper.calc6",userNo);
		
	}
	public int calcInfo7(String userNo) {
			
			return sqlSession.selectOne("pgameMapper.calc7",userNo);
			
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
		return (List)sqlSession.selectList("pgameMapper.pRecord", userNo);
	}
}
