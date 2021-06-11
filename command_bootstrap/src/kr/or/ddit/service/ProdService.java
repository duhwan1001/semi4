package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public interface ProdService {
	//목록조회
	Map<String,Object> selectProdList(SearchCriteria cri)throws SQLException;
	
	
	//생성
	public void regist(ProdVO product) throws SQLException;


	ProdVO getMember(int prodId)throws SQLException;
}
