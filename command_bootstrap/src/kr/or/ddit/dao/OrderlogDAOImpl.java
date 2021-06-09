package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogVO;

public class OrderlogDAOImpl implements OrderlogDAO {

	@Override
	public List<OrderlogVO> selectOrderlogSearchList(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<OrderlogVO> orderList = session.selectList("Orderlog-Mapper.selectSearchOrderlogList",userId, rowBounds);
		return orderList;
	}

	@Override
	public int selectOrderlogSearchListCount(SqlSession session, String userId,  SearchCriteria cri) throws SQLException {
		int cnt = session.selectOne("Orderlog-Mapper.selectSearchOrderlogListCount",userId);
		
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

}
