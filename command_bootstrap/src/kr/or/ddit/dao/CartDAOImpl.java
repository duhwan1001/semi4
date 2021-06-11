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
 
	@Override
	public void updateQtyPlus(SqlSession session, int cartNo) throws SQLException {
		session.update("Cart-Mapper.updateQtyPlus",cartNo);
	}

	@Override
	public void updateQtyMinus(SqlSession session, int cartNo) throws SQLException {
		session.update("Cart-Mapper.updateQtyMinus",cartNo);
	}

	@Override
	public void deleteCartItem(SqlSession session, int cartNo) throws SQLException {
		session.update("Cart-Mapper.deleteCartItem",cartNo);
	}

	@Override
	public void insertCartItem(SqlSession session, CartVO cart) throws SQLException {
		session.update("Cart-Mapper.insertCartItem",cart);
	}

}
