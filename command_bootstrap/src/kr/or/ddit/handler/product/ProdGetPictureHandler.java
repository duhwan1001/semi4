package kr.or.ddit.handler.product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.FileDownloadResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.utils.GetUploadPath;

public class ProdGetPictureHandler implements Handler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		String fileName = request.getParameter("picture");
		String savedPath =GetUploadPath.getUploadPath("prod.picture.upload");
		
		FileDownloadResolver.sendFile(fileName,savedPath,request,response);
		
		return url;
	}
}
