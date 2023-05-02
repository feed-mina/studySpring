package com.min.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.biz.board.BoardVO;
import com.min.biz.common.JDBCUtil;


// alt + shift + T : interface extract BoardService => selectAll => implements BoardService �� ���� �׷��� ���� �ۼ�
// 2. Vo�� �Ű������� return Ÿ������ ����ϸ鼭 �������� ������ ó�� DAO �ۼ�
//@Repository("boardDAO")


//@Component : �����ͺ��̽� ������ ó���ϴ� DAO Ŭ���������� @Component ������̼� ���  @Repository �� ����ϴ°� ���� 
@Repository
public class BoardDAO { 
		// JDBC ���� ���� : �ɹ����� ����
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		// private String title;
		
//	 
//		public void setTitle(String title) {
//			System.out.println("BoardDAO() : "+title);
//			this.title = title;
//		}

	 
		// SQL ��ɾ��
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)"; 
				// 1�� �������Ѽ� �Ϸù�ȣ�� ������Ų��.
		private final String BOARD_UPDATE = "update board set title=?, writer=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		// private final String BOARD_LIST = "select * from board order by seq desc";
		private final String BOARD_LIST_C = "select * from board where content like '%' ||?||'%' order by seq desc";		
		private final String BOARD_LIST_T = "select * from board where title like '%' ||?||'%' order by seq desc";		
// CURD ����� �޼ҵ� ����
// �� ���
		
		public void insertBoard(BoardVO vo) {
			System.out.println("===> JDBC�� insertBoard() ���ó��");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_INSERT);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getWriter());
				stmt.setString(3, vo.getContent());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
	// �� ����
		public void updateBoard(BoardVO vo) {
			System.out.println("===> JDBC�� updateBoard() ���ó��");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_UPDATE);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getWriter());
				stmt.setString(3, vo.getContent());
				stmt.setInt(4, vo.getSeq());
			
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		// �� ����
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> JDBC�� deleteBoard() ���ó��");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_DELETE);
				stmt.setInt(1,  vo.getSeq());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		// �� �� ��ȸ
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> JDBC�� getBoard() ���ó��");
			BoardVO board = null;
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_GET);
				stmt.setInt(1,  vo.getSeq());
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					board = new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return board;
		}
		
		// �� ��� ��ȸ
		// ����ִ� List ��ü�� while������ �����鼭 �����͸� �����´�. 
		public List<BoardVO> getBoardList(BoardVO vo){

			System.out.println("===> JDBC�� getBoardList() ���ó��");
			List<BoardVO> boardList = new ArrayList<BoardVO>();
			try {
				conn = JDBCUtil.getConnection();
				if(vo.getSearchCondition().equals("TITLE")) {
					stmt = conn.prepareStatement(BOARD_LIST_T);
				} else if (vo.getSearchCondition().equals("CONTENT")) {
					stmt = conn.prepareStatement(BOARD_LIST_C);
				}
				stmt.setString(1, vo.getSearchKeyword());
				rs = stmt.executeQuery();
				while(rs.next()) {
					BoardVO board = new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setCnt(rs.getInt("CNT"));
					boardList.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return boardList; 
	}			
}



//ctrl + shift + o Ű ����ϸ� import �� �����ü� �ִ�.