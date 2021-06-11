package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.CartDAO;
import kr.or.ddit.dto.CartVO;

public class CartServiceImpl implements CartService{
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private CartDAO cartDAO;
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	@Override
	public List<CartVO> getCartListById(String userId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<CartVO> cartList = cartDAO.selectCartList(session, userId);
			return cartList;
		}finally {
			session.close();
		}
	}

	@Override
	public void cartQtyPlus(int cartNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			cartDAO.updateQtyPlus(session, cartNo);
		} finally {
			session.close();
		}
	}

	@Override
	public void cartQtyMinus(int cartNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			cartDAO.updateQtyMinus(session, cartNo);
		} finally {
			session.close();
		}		
	}

	@Override
	public void cartDeleteItem(int cartNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			cartDAO.deleteCartItem(session, cartNo);
		} finally {
			session.close();
		}		
	}

	@Override
	public void cartInsertItem(CartVO cart) {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			cartDAO.insertCartItem(session, cart);
		} finally {
			session.close();
		}	
	}

}
