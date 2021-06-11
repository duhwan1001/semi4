package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogDetailVO;
import kr.or.ddit.dto.Orderlog_Prod_VO;

public interface OrderlogDetailDAO {
	
	List<OrderlogDetailVO> selectOrderlogDetailSearchList(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	int selectOrderlogDetailSearchListCount(SqlSession session, String userId, SearchCriteria cri) throws SQLException;
	
	void updateOrderlogDetail (SqlSession session, OrderlogDetailVO orderlog) throws SQLException;
	
	List<Orderlog_Prod_VO> selectOrderlogDetailListByOrderId(SqlSession session, String orderId) throws SQLException;
	
	void insertOrderlogDetail(SqlSession session, OrderlogDetailVO orderlogDetail) throws SQLException;
	
	int selectOrderDetaillogNextVal (SqlSession session) throws SQLException;
	
	void modifyOrderlogDetail(SqlSession session, Orderlog_Prod_VO orderlogProd) throws SQLException;
}
