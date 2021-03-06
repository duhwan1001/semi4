package kr.or.ddit.handler.product;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.FileUploadResolver;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.utils.GetUploadPath;
import kr.or.ddit.utils.MultipartHttpServletRequestParser;

public class ProdUploadPictureHandler implements Handler {

	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;

		MultipartHttpServletRequestParser multi = null;

		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

			// 파일 저장 경로 설정
			String uploadPath =GetUploadPath.getUploadPath("prod.picture.upload");
			// 사진이미지 저장
			List<AttachVO> attachList = FileUploadResolver.fileUpload(multi.getFileItems("pictureFile"), uploadPath);

			if (attachList.size() > 0) {
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				for (AttachVO attach : attachList) {
					out.print(attach.getFileName());
				}
			}

			// 기존이미지 삭제
			String oldPicture = multi.getParameter("oldPicture");
			File oldFile = new File(uploadPath + File.separator + oldPicture);
			if (oldFile.exists()) {
				oldFile.delete();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return url;
	}

}
