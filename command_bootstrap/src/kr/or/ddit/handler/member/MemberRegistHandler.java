package kr.or.ddit.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberRegistHandler implements Handler {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MEmberregisthandlerMEmberregisthandlerMEmberregisthandler");
		
		String url = "member/regist_success";
		
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userName = request.getParameter("username");
		String userRole = request.getParameter("userrole");
		String userPicture = request.getParameter("picture");
		
		String userPhone = "";
		for (String data : request.getParameterValues("phone")) {
			userPhone += data;
		}
		
		MemberVO member = new MemberVO();
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName(userName);
		member.setUserRole(userRole);
		member.setUserPhone(userPhone);
		member.setUserPicture(userPicture);
		
		try {
			memberService.regist(member);
		} catch (Exception e) {
			e.printStackTrace();
			url = null;
		}
		
		return url;
	}

}
