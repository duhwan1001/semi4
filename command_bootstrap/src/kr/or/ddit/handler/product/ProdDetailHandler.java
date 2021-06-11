package kr.or.ddit.handler.product;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdDetailHandler implements Handler {

	private ProdService prodService;
	public void setNoticeService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/detail";
		

		int prodId = Integer.parseInt(request.getParameter("prodId"));

		ProdVO product = null;
		
		try {
			product = prodService.getMember(prodId);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
