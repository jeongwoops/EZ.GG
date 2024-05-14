package com.kh.ez.pgame.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ez.pgame.model.vo.Pgame;

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


	
}
