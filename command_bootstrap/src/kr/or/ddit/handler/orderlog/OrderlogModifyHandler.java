package kr.or.ddit.handler.orderlog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogModifyHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}




	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("handler 진입");
		
		String url="orderlog/modify";
		
		String OrderlogStatus = request.getParameter("orderlogStatus");
		String orderId = request.getParameter("orderlogStatus");
		
		return url;
	}

}
