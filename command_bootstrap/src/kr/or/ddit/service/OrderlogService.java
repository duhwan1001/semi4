package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogVO;

public interface OrderlogService {
	
	Map<String,Object> getOrderlogList(String userId, SearchCriteria cri) throws SQLException;
	
	int getOrderlogListCount(String userId, SearchCriteria cri) throws SQLException;

	void modify(OrderlogVO orderlog) throws SQLException;
	
	List<OrderlogVO> getOrderlogListByOrderId(String orderId) throws SQLException;
	

}
