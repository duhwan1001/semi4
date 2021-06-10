package kr.or.ddit.handler.orderlog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderlogDetailVO;
import kr.or.ddit.dto.OrderlogVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogRegistHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url="orderlog/regist_success";
		
//		String userId = request.getParameter("userId");
//		String buyDate = request.getParameter("buyDate");
//		String orderId = request.getParameter("orderId");
//		int prodId = Integer.parseInt(request.getParameter("prodId"));
//		int prodQty = Integer.parseInt(request.getParameter("prodQty"));

		int prodId = 2;
		int prodQty = 1;
		
		String userId = "cdwcdw34";
		String orderId = "od"+"00001"+"_"+new Date();
		
		OrderlogVO orderlog = new OrderlogVO();
		
		OrderlogDetailVO orderlogDetail = new OrderlogDetailVO();
		
		orderlog.setOrderId(orderId);
		orderlog.setUserId(userId);
		orderlog.setBuyDate(new Date());
		
		orderlogDetail.setOrderId(orderId);
		orderlogDetail.setProdId(prodId);
		orderlogDetail.setProdQty(prodQty);
		
		orderlogService.regist(orderlog, orderlogDetail);
		
		
		
		request.setAttribute("orderlog", orderlog);
		
		return url;
	}

}
