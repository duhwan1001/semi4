package kr.or.ddit.handler.cart;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.controller.JSONResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.CartService;

public class CartQtyMinusHandler implements Handler{

	private CartService cartService;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	 
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		cartService.cartQtyMinus(cartNo);
		
		return url;
	}
	
}
