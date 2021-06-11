package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.Order_Prod_VO;
import kr.or.ddit.dto.OrderlogDetailVO;

public interface OrderlogDetailService {
	
	Map<String,Object> getOrderlogDetailList(String userId, SearchCriteria cri) throws SQLException;
	
	int getOrderlogDetailListCount(String userId, SearchCriteria cri) throws SQLException;

	void modify(OrderlogDetailVO orderlogDetail) throws SQLException;
	
	List<Order_Prod_VO> getOrderlogDetailListByOrderId(String orderId) throws SQLException;
	
	void regist(OrderlogDetailVO orderlogDetail)throws SQLException;
	
	void modifyDetail(Order_Prod_VO orderlogProd)throws SQLException;
}
