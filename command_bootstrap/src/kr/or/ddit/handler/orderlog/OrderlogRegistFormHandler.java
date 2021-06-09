package kr.or.ddit.handler.orderlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderlogVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogRegistFormHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url="orderlog/regist";
		
//		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
//		String userId = loginUser.getId();

		
		String userId = "cdwcdw34";
		
		OrderlogVO orderlog = new OrderlogVO();
		
		orderlog.setOrderId("a01");
		
		request.setAttribute("orderlog", orderlog);
		
		return url;
	}

}
