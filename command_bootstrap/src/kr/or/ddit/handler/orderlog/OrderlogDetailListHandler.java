package kr.or.ddit.handler.orderlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.Order_Prod_VO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogDetailService;
import kr.or.ddit.service.OrderlogService;

public class OrderlogDetailListHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}
	
	OrderlogDetailService orderlogDetailService;
	public void setOrderlogDetailService(OrderlogDetailService orderlogDetailService) {
		this.orderlogDetailService = orderlogDetailService;
	}



	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="orderlog/detail";
		
		
		String orderId = request.getParameter("orderId");
		List<Order_Prod_VO> orderlogProdList = orderlogDetailService.getOrderlogDetailListByOrderId(orderId);
		
		
		
		request.setAttribute("orderlogProdList", orderlogProdList);
		
		return url;
	}

}
