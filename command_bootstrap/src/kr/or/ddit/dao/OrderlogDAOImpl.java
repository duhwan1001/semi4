package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.Order_Prod_VO;
import kr.or.ddit.dto.OrderlogVO;

public class OrderlogDAOImpl implements OrderlogDAO {

	@Override
	public List<Order_Prod_VO> selectOrderlogSearchList(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {

		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		
		System.out.println("offset : "+offset+", limit : "+limit);
		
		cri.setLoginUserId(userId);
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Order_Prod_VO> orderList = session.selectList("Orderlog-Mapper.selectSearchOrderlogList",cri, rowBounds);
		
		return orderList;
	}

	@Override
	public int selectOrderlogSearchListCount(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {
		cri.setLoginUserId(userId);
		System.out.println("cri.getKeyword() : " + cri.getKeyword());
		int cnt = session.selectOne("Orderlog-Mapper.selectSearchOrderlogListCount",cri);
		
		return cnt;
	}

	@Override
	public void updateOrderlog(SqlSession session, OrderlogVO orderlog) throws SQLException {
		session.update("Orderlog-Mapper.modifyOrderlog",orderlog);
	}

	@Override
	public List<OrderlogVO> selectOrderlogListByOrderId(SqlSession session, String orderId) throws SQLException {
		List<OrderlogVO> orderlogList = session.selectList("Orderlog-Mapper.selectOrderlogListByOrderId",orderId);
			return orderlogList;
	}

	@Override
	public void insertOrderlog(SqlSession session, OrderlogVO orderlog) throws SQLException {
		session.update("Orderlog-Mapper.insertOrderlog",orderlog);
		
	}

	@Override
	public int selectOrderlogNextVal(SqlSession session) throws SQLException {
		int cnt = 0;
		cnt = session.selectOne("Orderlog-Mapper.selectOrderlogNextVal");
		return cnt;
	}

}
