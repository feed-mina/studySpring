package com.min.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.biz.board.BoardVO;
import com.min.biz.common.JDBCUtil;


// alt + shift + T : interface extract BoardService => selectAll => implements BoardService 가 생김 그러나 따로 작성
// 2. Vo를 매개변수와 return 타입으로 사용하면서 실질적인 데이터 처리 DAO 작성
//@Repository("boardDAO")


//@Component : 데이터베이스 연동을 처리하는 DAO 클래스에서는 @Component 어노테이션 대신  @Repository 를 사용하는게 낫다 
@Repository
public class BoardDAO { 
		// JDBC 관련 변수 : 맴버변수 선언
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		// private String title;
		
//	 
//		public void setTitle(String title) {
//			System.out.println("BoardDAO() : "+title);
//			this.title = title;
//		}

	 
		// SQL 명령어들
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)"; 
				// 1씩 증가시켜서 일련번호를 증가시킨다.
		private final String BOARD_UPDATE = "update board set title=?, writer=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		// private final String BOARD_LIST = "select * from board order by seq desc";
		private final String BOARD_LIST_C = "select * from board where content like '%' ||?||'%' order by seq desc";		
		private final String BOARD_LIST_T = "select * from board where title like '%' ||?||'%' order by seq desc";		
// CURD 기능의 메소드 구현
// 글 등록
		
		public void insertBoard(BoardVO vo) {
			System.out.println("===> JDBC로 insertBoard() 기능처리");
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
		
	// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> JDBC로 updateBoard() 기능처리");
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
		
		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> JDBC로 deleteBoard() 기능처리");
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
		
		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> JDBC로 getBoard() 기능처리");
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
		
		// 글 목록 조회
		// 비어있는 List 객체에 while루프를 돌리면서 데이터를 가져온다. 
		public List<BoardVO> getBoardList(BoardVO vo){

			System.out.println("===> JDBC로 getBoardList() 기능처리");
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



//ctrl + shift + o 키 사용하면 import 로 가져올수 있다.