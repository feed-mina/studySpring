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


// alt + shift + T : interface extract BoardService => selectAll => implements BoardService �� ���� �׷��� ���� �ۼ�
// 2. Vo�� �Ű������� return Ÿ������ ����ϸ鼭 �������� ������ ó�� DAO �ۼ�
//@Repository("boardDAO")


//@Component : �����ͺ��̽� ������ ó���ϴ� DAO Ŭ���������� @Component ������̼� ���  @Repository �� ����ϴ°� ���� 
@Repository
public class BoardDAOSpring { 
		// JDBC ���� ���� : �ɹ����� ���� >> JdbcTemplate �� �ٲ� �߿�!! JdbcTemplate�� �̿��ϸ� ���ٷ� CRUD�� �����ϰ� �ȴ�.
	@Autowired
	private JdbcTemplate spring;
	// SQL ��ɾ��
	//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)"; 
				// 1�� �������Ѽ� �Ϸù�ȣ�� ������Ų��.
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)"; 
		private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		private final String BOARD_LIST = "select * from board order by seq desc";
				
// SPRING���� CURD ����� �޼ҵ� ���� > update�ż���θ� �����ϴ� !
// �� ���
		
		public void insertBoard(BoardVO vo) {
			System.out.println("===> SPRING���� insertBoard() ���ó��");
			spring.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		}
		
	// �� ����
		public void updateBoard(BoardVO vo) {
			System.out.println("===> SPRING���� updateBoard() ���ó��");
			spring.update(BOARD_UPDATE,  vo.getTitle(), vo.getContent(), vo.getSeq());
		}
		
		// �� ����
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> SPRING���� deleteBoard() ���ó��");
			spring.update(BOARD_DELETE, vo.getSeq());
		}
		
		// �� �� ��ȸ
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> SPRING���� getBoard() ���ó��");
			Object[] params = {vo.getSeq()}; // ? ��ɿ� �ش���
			return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
			
		//	BoardVO board = null;
		//	return board;
		}
		
		// �� ��� ��ȸ
		// ����ִ� List ��ü�� while������ �����鼭 �����͸� �����´�. 
		public List<BoardVO> getBoardList(BoardVO vo){
			System.out.println("===> SPRING���� getBoardList() ���ó��");
			return spring.query(BOARD_LIST, new BoardRowMapper());
			
			
			// List<BoardVO> boardList = new ArrayList<BoardVO>();
			// return boardList; 
	}			
}

 