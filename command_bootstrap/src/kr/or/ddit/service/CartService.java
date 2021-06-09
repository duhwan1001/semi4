package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.CartVO;
import kr.or.ddit.dto.MemberVO;

public interface CartService {
	List<CartVO> getCartListById(String userId) throws SQLException;
	
	void cartQtyPlus(int cartNo) throws SQLException;
	
	void cartQtyMinus(int cartNo) throws SQLException;
}
