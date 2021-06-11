package kr.or.ddit.handler.product;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdRegistHandler implements Handler {
	
	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService=prodService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/regist_success";
		
		String prodName = request.getParameter("prodName");
		String prodImg = request.getParameter("prodImg");
		int prodCost = Integer.parseInt(request.getParameter("prodCost"));
		String prodSize = request.getParameter("prodSize");
		String prodClass = request.getParameter("prodClass");
		String prodWho = request.getParameter("prodWho");
		int prodQty = Integer.parseInt(request.getParameter("prodQty"));
		String prodDesc = request.getParameter("prodDesc");
		
		// MemberVO setting
		ProdVO product = new ProdVO();
		product.setProdName(prodName);
		product.setProdImg(prodImg);
		product.setProdCost(prodCost);
		product.setProdSize(prodSize);
		product.setProdClass(prodClass);
		product.setProdWho(prodWho);
		product.setProdQty(prodQty);
		product.setProdDesc(prodDesc);
		
		
		try {
			prodService.regist(product);
			
		}catch (SQLException e) {
			e.printStackTrace();
			url="prod/regist_fail";
		}
		
		
		return url;
	}

}
