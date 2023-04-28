package com.min.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;
import com.min.biz.common.LogAdvice;


// 4. Service 구현 클래스 : 서비스인터페이스를 implements 한 ServiceImpl 클래스를 작성

// @Component("boardService") // id를 @Component("id이름") 으로 넣어야 한다. 
//@Component : 비즈니스 로직을 처리하는 Service클래스에서는 @Component 어노테이션 대신  @Service 를 사용하는게 낫다 

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // Type Injection
	private BoardDAOSpring boardDAO;

//		private LogAdvice log;
	
//	public BoardServiceImpl() { log = new LogAdvice();}
	
	
	// public BoardServiceImpl() {}
		
	
	// 생성자 injection
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

	// implements 를 했기 때문에 BoardeService까지 오버라이드가 되어있다.
	@Override
	public void insertBoard(BoardVO vo) {
		// LogAdvice log = new LogAdvice();
		//		log.printLog();
		// -- exceptionObj , AfterThrowingAdvice 오류 테스트
		// 	if(vo.getSeq() == 0) { throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다."); }
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
