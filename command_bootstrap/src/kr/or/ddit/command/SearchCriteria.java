package kr.or.ddit.command;

public class SearchCriteria extends Criteria {

	private String searchType = ""; // 검색구분
	private String keyword = ""; // 검색어
	private String loginUserId = ""; // 로그인유저아이디
	private String searchType_2 = ""; // 검색구분2

	public String getSearchType_2() {
		return searchType_2;
	}
	public void setSearchType_2(String searchType_2) {
		this.searchType_2 = searchType_2;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
