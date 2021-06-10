package kr.or.ddit.handler.orderlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogModifyFormHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}




	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("handler 진입");
		String url="orderlog/modify";
		
		
		int orderDetailNo = Integer.parseInt(request.getParameter("orderDetailNo"));
		System.out.println("moForm Han : orderDetailNo :"+orderDetailNo);
		String userId = "cdwcdw34";
		
		request.setAttribute("orderDetailNo", orderDetailNo);
		
		return url;
	}

}
