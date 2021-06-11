package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.ProdDAO;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.ProdVO;

public class ProdServiceImpl implements ProdService{

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private ProdDAO prodDAO;
	public void setProdDAO(ProdDAO prodDAO) {
		this.prodDAO = prodDAO;
	}
	
	@Override
	public Map<String, Object> selectProdList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		try {			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(prodDAO.selectProdListCount(session, cri));
			
			List<ProdVO> prodList = prodDAO.selectProdList(session,cri);
			
			dataMap.put("prodList", prodList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}

	@Override
	public void regist(ProdVO product) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			prodDAO.insertProd(session, product);
		} finally {
			session.close();
		}
		
	}

	@Override
	public ProdVO getMember(int prodId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			ProdVO product = prodDAO.selectProdByProdId(session, prodId);
			return product;
		} finally {
			session.close();
		}
	}
}
