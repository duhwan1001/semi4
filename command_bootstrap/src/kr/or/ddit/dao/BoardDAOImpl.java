package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws SQLException {

		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList=
				session.selectList("Board-Mapper.selectSearchBoardList",cri,rowBounds);
		
		return boardList;
	}

	@Override
	public int selectSearchBoardListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Board-Mapper.selectSearchBoardListCount",cri);
		return count;
	}

	@Override
	public BoardVO selectBoardbybno(SqlSession session, int boardNo) throws SQLException {
		BoardVO Board=session.selectOne("Board-Mapper.selectBoardBybno",boardNo);
		return Board;
	}

	@Override
	public void increaseViewCount(SqlSession session, int boardNo) throws SQLException {
		session.update("Board-Mapper. increaseViewCount", boardNo);

	}

	@Override
	public int selectBoardSequenceNextValue(SqlSession session) throws SQLException {
		int seq_num=session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertBoard(SqlSession session, BoardVO board) throws SQLException {
		session.update("Board-Mapper.insertBoard",board);

	}

	@Override
	public void updateBoard(SqlSession session, BoardVO board) throws SQLException {
		session.update("Board-Mapper.updateBoard",board);

	}

	@Override
	public void deleteBoard(SqlSession session, int boardNo) throws SQLException {
		session.update("Board-Mapper.deleteBoard",boardNo);

	}

	@Override
	public int selectBoardbyboardNo(SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

}
