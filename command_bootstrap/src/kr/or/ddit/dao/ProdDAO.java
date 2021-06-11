package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public interface ProdDAO {
	//제품 조회
	List<ProdVO> selectProdList(SqlSession session,SearchCriteria cri)throws SQLException;
	
	//데이터 조회
	int selectProdListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	//데이터 입력
	public void insertProd(SqlSession session, ProdVO product) throws SQLException;

	//회원정보 조회
	ProdVO selectProdByProdId(SqlSession session, int prodId) throws SQLException;
	
}
