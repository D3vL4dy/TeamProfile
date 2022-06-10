package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.WReplyVO;

public class WreplyDAOImpl implements WreplyDAO {

	@Override
	public void insertWReply(SqlSession session, WReplyVO wReply) throws SQLException {
		session.update("WReply-Mapper.insertWReply",wReply);
	}

	@Override
	public void updateWReply(SqlSession session, WReplyVO wReply) throws SQLException {
		session.update("WReply-Mapper.updateWReply",wReply);
	}

	@Override
	public void deleteWReply(SqlSession session, int w_rno) throws SQLException {
		session.update("WReply-Mapper.deleteWReply", w_rno);

	}

	@Override
	public int selectWReplySeqNextValue(SqlSession session) throws SQLException {
		int w_rno = (Integer)session.selectOne("WReply-Mapper.selectWReplySeqNextValue");
		return w_rno;
	}

	@Override
	public List<WReplyVO> selectWReplyListPage(SqlSession session, int wno, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<WReplyVO> wReplyList=session.selectList("WReply-Mapper.selectWReplyList", wno, rowBounds);
		return wReplyList;
	}

	@Override
	public int countWReply(SqlSession session, int wno) throws SQLException {
		int count = session.selectOne("WReply-Mapper.countWReply", wno);
		return count;
	}

}
