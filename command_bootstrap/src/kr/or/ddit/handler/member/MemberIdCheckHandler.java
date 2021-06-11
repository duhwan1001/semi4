package kr.or.ddit.handler.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberIdCheckHandler implements Handler {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		
		MemberVO member = memberService.getMember(id);
		
		if(member != null) {
			out.print("duplicated");
			out.close();
		}

		System.out.println(member);
		
		return null;
	}

}
