package kr.or.ddit.handler.orderlog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.dto.Order_Prod_VO;
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
		
		
		String url=null;

		
		
		
		ObjectMapper mapper = new ObjectMapper();
		Order_Prod_VO orderlogProd = mapper.readValue(request.getReader(), Order_Prod_VO.class);
		
		int prodId = orderlogProd.getProdId();
		int prodQty = orderlogProd.getProdQty();
		
		String userId = "cdwcdw34";
		String orderId = "od" + "00001" + "_" + new Date();

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
