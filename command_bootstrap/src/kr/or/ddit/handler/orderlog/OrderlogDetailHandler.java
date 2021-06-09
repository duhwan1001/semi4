package kr.or.ddit.handler.orderlog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderlogVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogDetailHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}




	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url="orderlog/detail";
		
		
		String orderId = request.getParameter("orderId");
		List<OrderlogVO> orderlogList = orderlogService.getOrderlogListByOrderId(orderId);
		System.out.println("detail handler query호ㅜ");
		request.setAttribute("orderlogList", orderlogList);
		return url;
	}

}
