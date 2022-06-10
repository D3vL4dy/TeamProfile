package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.QReplyVO;

public class QReplyDAOImpl implements QReplyDAO {

	@Override
	public void insertQReply(SqlSession session, QReplyVO qreply) throws SQLException {
		session.update("QReply-Mapper.insertQReply",qreply);
	}

	@Override
	public void updateQReply(SqlSession session, QReplyVO qreply) throws SQLException {
		session.update("QReply-Mapper.updateQReply",qreply);
	}

	@Override
	public void deleteQReply(SqlSession session, int q_Rno) throws SQLException {
		session.update("QReply-Mapper.deleteQReply",q_Rno);

	}

	@Override
	public int selectQReplySeqNextValue(SqlSession session) throws SQLException {
		int q_Rno=(Integer)session.selectOne("QReply-Mapper.selectQReplySeqNextValue");
		return q_Rno;
	}

	@Override
	public List<QReplyVO> selectQReplyListPage(SqlSession session, int qno, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<QReplyVO> qreplyList=session.selectList("QReply-Mapper.selectQReplyList",qno,rowBounds);
		return qreplyList;
	}

	@Override
	public int countQReply(SqlSession session, int qno) throws SQLException {
		int count=session.selectOne("QReply-Mapper.countQReply",qno);
		return count;
	}

}
