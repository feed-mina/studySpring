package com.min.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;
import com.min.biz.common.LogAdvice;


// 4. Service ���� Ŭ���� : �����������̽��� implements �� ServiceImpl Ŭ������ �ۼ�

// @Component("boardService") // id�� @Component("id�̸�") ���� �־�� �Ѵ�. 
//@Component : ����Ͻ� ������ ó���ϴ� ServiceŬ���������� @Component ������̼� ���  @Service �� ����ϴ°� ���� 

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // Type Injection
	private BoardDAOSpring boardDAO;

//		private LogAdvice log;
	
//	public BoardServiceImpl() { log = new LogAdvice();}
	
	
	// public BoardServiceImpl() {}
		
	
	// ������ injection
	/*
	public BoardServiceImpl(BoardDAO boardDAO) {
		super();
		this.boardDAO = boardDAO; }
*/
	
	// Setter injection
	/*
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;	}
	 */

	// implements �� �߱� ������ BoardeService���� �������̵尡 �Ǿ��ִ�.
	@Override
	public void insertBoard(BoardVO vo) {
		// LogAdvice log = new LogAdvice();
		//		log.printLog();
		// -- exceptionObj , AfterThrowingAdvice ���� �׽�Ʈ
		// 	if(vo.getSeq() == 0) { throw new IllegalArgumentException("0�� ���� ��� �� �� �����ϴ�."); }
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
	//	LogAdvice log = new LogAdvice();
	//		log.printLog();
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
	//	LogAdvice log = new LogAdvice();
	//		log.printLog();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
	//	LogAdvice log = new LogAdvice();
	//			log.printLog();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
	//	LogAdvice log = new LogAdvice();
	//			log.printLog();
		return boardDAO.getBoardList(vo);
	}

}
