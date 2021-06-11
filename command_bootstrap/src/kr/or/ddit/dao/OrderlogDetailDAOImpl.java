package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.Order_Prod_VO;
import kr.or.ddit.dto.OrderlogDetailVO;

public class OrderlogDetailDAOImpl implements OrderlogDetailDAO {

	@Override
	public List<OrderlogDetailVO> selectOrderlogDetailSearchList(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<OrderlogDetailVO> orderList = session.selectList("Orderlog-Mapper.selectSearchOrderlogDetailList",userId, rowBounds);
		
		System.out.println(orderList.get(0).getOrderId());
		
		return orderList;
	}

	@Override
	public int selectOrderlogDetailSearchListCount(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {
		int cnt = session.selectOne("Orderlog-Mapper.selectSearchOrderlogDetailListCount",userId);
		
		return cnt;
	}

	@Override
	public void updateOrderlogDetail(SqlSession session, OrderlogDetailVO orderlog) throws SQLException {
		session.update("Orderlog-Mapper.modifyOrderlogDetail",orderlog);
	}

	@Override
	public List<Order_Prod_VO> selectOrderlogDetailListByOrderId(SqlSession session, String orderId) throws SQLException {
		List<Order_Prod_VO> orderlogList = session.selectList("Orderlog-Mapper.selectOrderlogDetailListByOrderId",orderId);
			return orderlogList;
	}

	@Override
	public void insertOrderlogDetail(SqlSession session, OrderlogDetailVO orderlogDetail) throws SQLException {
		session.update("Orderlog-Mapper.insertOrderlogDetail",orderlogDetail);
	}

	@Override
	public int selectOrderDetaillogNextVal(SqlSession session) throws SQLException {
		int cnt = 0; 
		System.out.println("Detail nextval 쿼리전");
		cnt = session.selectOne("Orderlog-Mapper.selectOrderDetaillogNextVal");
		return cnt;
	}

	@Override
	public void modifyOrderlogDetail(SqlSession session, Order_Prod_VO orderlogProd) throws SQLException {
		session.update("Orderlog-Mapper.modifyOrderlogDetail",orderlogProd);
		
	}

}
