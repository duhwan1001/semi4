package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.OrderlogDAO;
import kr.or.ddit.dto.OrderlogVO;

public class OrderlogServiceImpl implements OrderlogService{

	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	OrderlogDAO orderlogDAO;
	public void setOrderlogDAO(OrderlogDAO orderlogDAO) {
		this.orderlogDAO = orderlogDAO;
	}
	
	@Override
	public Map<String, Object> getOrderlogList(String userId, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			System.out.println(cri.getKeyword());
			System.out.println(cri.getPage());
			System.out.println(cri.getSearchType());
			System.out.println(cri.getPerPageNum());
			
			pageMaker.setTotalCount(orderlogDAO.selectOrderlogSearchListCount(session, userId, cri));
			System.out.println("totalcount 후");
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			List<OrderlogVO> orderlogList = orderlogDAO.selectOrderlogSearchList(session, userId, cri);
			
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
	
	

}
