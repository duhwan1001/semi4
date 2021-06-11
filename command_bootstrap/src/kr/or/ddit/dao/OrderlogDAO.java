package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogVO;
import kr.or.ddit.dto.Orderlog_Prod_VO;

public interface OrderlogDAO {
	
	List<Orderlog_Prod_VO> selectOrderlogSearchList(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	int selectOrderlogSearchListCount(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	void updateOrderlog (SqlSession session, OrderlogVO orderlog) throws SQLException;
	
	List<OrderlogVO> selectOrderlogListByOrderId(SqlSession session, String orderId) throws SQLException;
	
	void insertOrderlog(SqlSession session, OrderlogVO orderlog) throws SQLException;
	
	int selectOrderlogNextVal(SqlSession session) throws SQLException;
	
}
