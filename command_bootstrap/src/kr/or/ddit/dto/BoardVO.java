package kr.or.ddit.dto;

import java.util.Date;

public class BoardVO {

	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardRegdate;
	private String boardViewcnt;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardRegdate() {
		return boardRegdate;
	}

	public void setBoardRegdate(Date boardRegdate) {
		this.boardRegdate = boardRegdate;
	}

	public String getBoardViewcnt() {
		return boardViewcnt;
	}

	public void setBoardViewcnt(String boardViewcnt) {
		this.boardViewcnt = boardViewcnt;
	}

	public void setReplucnt(int replycnt) {
		// TODO Auto-generated method stub
		
	}

}
