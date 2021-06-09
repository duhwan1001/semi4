package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogVO;

public interface OrderlogDAO {
	
	List<OrderlogVO> selectOrderlogSearchList(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	int selectOrderlogSearchListCount(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	void updateOrderlog (SqlSession session, OrderlogVO orderlog) throws SQLException;
	
	List<OrderlogVO> selectOrderlogListByOrderId(SqlSession session, String orderId) throws SQLException;
	
	
	
	
}
