package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public interface BoardService {
	
	//목록조회
	Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
	
	//상세보기
	BoardVO getBoard(int boardNo) throws SQLException;
	
	//수정화면 상세
	BoardVO getBoardForModify(int boardNo) throws SQLException;
	
	//등록
	void regist(BoardVO board) throws SQLException;
	
	//수정
	void modify(BoardVO board) throws SQLException;
	
	//삭제
	void remove(int boardNo) throws SQLException;
}
