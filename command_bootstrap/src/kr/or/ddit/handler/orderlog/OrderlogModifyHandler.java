package kr.or.ddit.handler.orderlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.Orderlog_Prod_VO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogDetailService;
import kr.or.ddit.service.OrderlogService;

public class OrderlogModifyHandler implements Handler {

	private OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}

	private OrderlogDetailService orderlogDeteailService; 
	public void setOrderlogDeteailService(OrderlogDetailService orderlogDeteailService) {
		this.orderlogDeteailService = orderlogDeteailService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String url="orderlog/modify_success";
		
		String orderDetailStatus = request.getParameter("orderChooseSelect");
		int orderDetailNo = Integer.parseInt(request.getParameter("orderDetailNo"));
		System.out.println("mo Han : orderDetailNo :"+orderDetailNo);
		Orderlog_Prod_VO orderlogProd = new Orderlog_Prod_VO();
		
		orderlogProd.setOrderDetailNo(orderDetailNo);
		orderlogProd.setOrderDetailStatus(orderDetailStatus);
		
		orderlogDeteailService.modifyDetail(orderlogProd);
		
		return url;
	}

}
