package com.min.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.min.biz.board.BoardVO;
import com.min.biz.common.JDBCUtil;


// alt + shift + T : interface extract BoardService => selectAll => implements BoardService 가 생김 그러나 따로 작성
// 2. Vo를 매개변수와 return 타입으로 사용하면서 실질적인 데이터 처리 DAO 작성
//@Repository("boardDAO")


//@Component : 데이터베이스 연동을 처리하는 DAO 클래스에서는 @Component 어노테이션 대신  @Repository 를 사용하는게 낫다 
@Repository
public class BoardDAOSpring { 
		// JDBC 관련 변수 : 맴버변수 선언 >> JdbcTemplate 로 바꿈 중요!! JdbcTemplate를 이용하면 한줄로 CRUD가 가능하게 된다.
	@Autowired
	private JdbcTemplate spring;
	// SQL 명령어들
	//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)"; 
				// 1씩 증가시켜서 일련번호를 증가시킨다.
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)"; 
		private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		private final String BOARD_LIST = "select * from board order by seq desc";
				
// SPRING으로 CURD 기능의 메소드 구현 > update매서드로만 가능하다 !
// 글 등록
		
		public void insertBoard(BoardVO vo) {
			System.out.println("===> SPRING으로 insertBoard() 기능처리");
			spring.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		}
		
	// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> SPRING으로 updateBoard() 기능처리");
			spring.update(BOARD_UPDATE,  vo.getTitle(), vo.getContent(), vo.getSeq());
		}
		
		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> SPRING으로 deleteBoard() 기능처리");
			spring.update(BOARD_DELETE, vo.getSeq());
		}
		
		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> SPRING으로 getBoard() 기능처리");
			Object[] params = {vo.getSeq()}; // ? 기능에 해당함
			return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
			
		//	BoardVO board = null;
		//	return board;
		}
		
		// 글 목록 조회
		// 비어있는 List 객체에 while루프를 돌리면서 데이터를 가져온다. 
		public List<BoardVO> getBoardList(BoardVO vo){
			System.out.println("===> SPRING으로 getBoardList() 기능처리");
			return spring.query(BOARD_LIST, new BoardRowMapper());
			
			
			// List<BoardVO> boardList = new ArrayList<BoardVO>();
			// return boardList; 
	}			
}

 