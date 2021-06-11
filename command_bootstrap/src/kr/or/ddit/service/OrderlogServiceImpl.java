package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.OrderlogDAO;
import kr.or.ddit.dao.OrderlogDetailDAO;
import kr.or.ddit.dto.OrderlogDetailVO;
import kr.or.ddit.dto.OrderlogVO;
import kr.or.ddit.dto.Orderlog_Prod_VO;

public class OrderlogServiceImpl implements OrderlogService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private OrderlogDAO orderlogDAO;
	public void setOrderlogDAO(OrderlogDAO orderlogDAO) {
		this.orderlogDAO = orderlogDAO;
	}
	
	private OrderlogDetailDAO orderlogDetailDAO;
	public void setOrderlogDetailDAO(OrderlogDetailDAO orderlogDetailDAO) {
		this.orderlogDetailDAO = orderlogDetailDAO;
	}

	@Override
	public Map<String, Object> getOrderlogList(String userId, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			pageMaker.setTotalCount(orderlogDAO.selectOrderlogSearchListCount(session, userId, cri));
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			List<Orderlog_Prod_VO> orderlogList = orderlogDAO.selectOrderlogSearchList(session, userId, cri);
			
			dataMap.put("orderlogList", orderlogList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}

	@Override
	public int getOrderlogListCount(String userId, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int cnt = orderlogDAO.selectOrderlogSearchListCount(session, userId, cri);
			return cnt;
		}finally {
			session.close();
		}		
	}

	@Override
	public void modify(OrderlogVO orderlog) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			orderlogDAO.updateOrderlog(session, orderlog);
			
			return ; 
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<OrderlogVO> getOrderlogListByOrderId(String orderId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<OrderlogVO> orderlogList = orderlogDAO.selectOrderlogListByOrderId(session, orderId);
			return orderlogList;
		}finally {
			session.close();
			
		}
		
	}

	@Override
	public void regist(OrderlogVO orderlog,OrderlogDetailVO orderlogDetail) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			int val = orderlogDAO.selectOrderlogNextVal(session);
			String orderId = "ORD"+val+"_"+String.valueOf(new Date().getTime());
			
			orderlog.setOrderId(orderId);
			orderlogDAO.insertOrderlog(session, orderlog);
			
			int orderDetailNo = orderlogDetailDAO.selectOrderDetaillogNextVal(session);
			
			orderlogDetail.setOrderDetailNo(orderDetailNo);
			orderlogDetail.setOrderId(orderId);
			
			orderlogDetailDAO.insertOrderlogDetail(session, orderlogDetail);
			
		}finally {
			session.close();
		}
		 
		
	}
	
	

}
