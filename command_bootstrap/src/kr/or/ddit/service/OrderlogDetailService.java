package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.OrderlogDetailVO;
import kr.or.ddit.dto.Orderlog_Prod_VO;

public interface OrderlogDetailService {
	
	Map<String,Object> getOrderlogDetailList(String userId, SearchCriteria cri) throws SQLException;
	
	int getOrderlogDetailListCount(String userId, SearchCriteria cri) throws SQLException;

	void modify(OrderlogDetailVO orderlogDetail) throws SQLException;
	
	List<Orderlog_Prod_VO> getOrderlogDetailListByOrderId(String orderId) throws SQLException;
	
	void regist(OrderlogDetailVO orderlogDetail)throws SQLException;
}
