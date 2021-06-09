package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.CartVO;

public class CartDAOImpl implements CartDAO{

	@Override
	public List<CartVO> selectCartList(SqlSession session, String userId) throws SQLException {
		List<CartVO> cartList =
				session.selectList("Cart-Mapper.selectCartById", userId);
		
		return cartList;
	}

}
