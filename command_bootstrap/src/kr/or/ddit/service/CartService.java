package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.CartVO;

public interface CartService {
	List<CartVO> getCartListById(String userId) throws SQLException;
}
