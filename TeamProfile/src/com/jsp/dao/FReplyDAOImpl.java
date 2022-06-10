package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.FReplyVO;

public class FReplyDAOImpl implements FReplyDAO {

	@Override
	public void insertFReply(SqlSession session, FReplyVO freply) throws SQLException {
		session.update("FReply-Mapper.insertFReply",freply);
	}

	@Override
	public void updateFReply(SqlSession session, FReplyVO freply) throws SQLException {
		session.update("FReply-Mapper.updateFReply",freply);
	}

	@Override
	public void deleteFReply(SqlSession session, int f_rno) throws SQLException {
		session.update("FReply-Mapper.deleteFReply",f_rno);

	}

	@Override
	public int selectFReplySeqNextValue(SqlSession session) throws SQLException {
		int fRno=(Integer)session.selectOne("FReply-Mapper.selectFReplySeqNextValue");
		return fRno;
	}

	@Override
	public List<FReplyVO> selectFReplyListPage(SqlSession session, int fno, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<FReplyVO> freplyList=session.selectList("FReply-Mapper.selectFReplyList",fno,rowBounds);
		return freplyList;
	}

	@Override
	public int countReply(SqlSession session, int fno) throws SQLException {
		int count=session.selectOne("FReply-Mapper.countFReply",fno);
		return count;
	}

}
