package kr.or.ddit.handler.orderlog;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderlogService;

public class OrderlogListHandler implements Handler {

	OrderlogService orderlogService;
	public void setOrderlogService(OrderlogService orderlogService) {
		this.orderlogService = orderlogService;
	}




	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("list handler 진입");
		String url="orderlog/list";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");
		
		System.out.println(page);
		System.out.println(perPageNum);
		System.out.println(keyword);
		System.out.println(searchType);
		
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setKeyword(keyword);
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);

//		String userId = request.getParameter("userId");
		String userId = "cdwcdw34";
		try {
		Map<String, Object> dataMap = orderlogService.getOrderlogList(userId, cri);
		request.setAttribute("dataMap", dataMap);
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		}catch(SQLException e) {
			e.printStackTrace();
			url = null;
		}
		return url;
	}

}
