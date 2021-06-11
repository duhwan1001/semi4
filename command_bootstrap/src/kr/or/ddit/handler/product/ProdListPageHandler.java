package kr.or.ddit.handler.product;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdListPageHandler implements Handler {

	private ProdService prodService;
	public void setNoticeService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "prod/list";
		
		String searchType_2 = request.getParameter("prodWho");
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);		
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		cri.setSearchType_2(searchType_2);
		Map<String,Object> dataMap = prodService.selectProdList(cri);
		
		request.setAttribute("prodList", dataMap.get("prodList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		
		return url;
	}

}
