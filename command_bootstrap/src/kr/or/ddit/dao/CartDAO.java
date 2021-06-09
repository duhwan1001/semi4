package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.CartVO;

public interface CartDAO {
	// 장바구니 내역 조회
	List<CartVO> selectCartList(SqlSession session, String userId) throws SQLException;

	// 장바구니 수량 추가
	void updateQtyPlus(SqlSession session, int cartNo) throws SQLException;
	
	// 장바구니 수량 빼기
	void updateQtyMinus(SqlSession session, int cartNo) throws SQLException;
}
