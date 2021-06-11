package kr.or.ddit.handler.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.CartVO;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.CartService;

public class CartDeleteItemHandler implements Handler{
	private CartService cartService;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	 
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "cart/delete_success";
		
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		cartService.cartDeleteItem(cartNo);
		
		return url;
	}
}
