package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.OrderlogDetailDAO;
import kr.or.ddit.dto.OrderlogDetailVO;
import kr.or.ddit.dto.Orderlog_Prod_VO;

public class OrderlogDetailServiceImpl implements OrderlogDetailService{

	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	OrderlogDetailDAO orderlogDetailDAO;
	public void setOrderlogDetailDAO(OrderlogDetailDAO orderlogDetailDAO) {
		this.orderlogDetailDAO = orderlogDetailDAO;
	}

	@Override
	public Map<String, Object> getOrderlogDetailList(String userId, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			pageMaker.setTotalCount(orderlogDetailDAO.selectOrderlogDetailSearchListCount(session, userId, cri));

			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			List<OrderlogDetailVO> orderlogDetailList = orderlogDetailDAO.selectOrderlogDetailSearchList(session, userId, cri);
			
			dataMap.put("orderlogDetailList", orderlogDetailList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
			
			
		}finally {
			session.close();
		}
	}

	@Override
	public int getOrderlogDetailListCount(String userId, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int cnt = orderlogDetailDAO.selectOrderlogDetailSearchListCount(session, userId, cri);
			return cnt;
		}finally {
			session.close();
		}		
	}

	@Override
	public void modify(OrderlogDetailVO orderlogDetail) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			orderlogDetailDAO.updateOrderlogDetail(session, orderlogDetail);
			
			return ; 
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Orderlog_Prod_VO> getOrderlogDetailListByOrderId(String orderId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Orderlog_Prod_VO> orderlogDetailList = orderlogDetailDAO.selectOrderlogDetailListByOrderId(session, orderId);
			return orderlogDetailList;
		}finally {
			session.close();
			
		}
		
	}

	@Override
	public void regist(OrderlogDetailVO orderlogDetail) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			orderlogDetailDAO.insertOrderlogDetail(session, orderlogDetail);
		}finally {
			session.close();
		}
		 
		
	}

	
	

}
