package com.min.biz.board.impl;

import java.util.List;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;


// 4. Service 구현 클래스 : 서비스인터페이스를 implements 한 ServiceImpl 클래스를 작성
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	
	// public BoardServiceImpl() {}
		
	
	// 생성자 injection

	public BoardServiceImpl(BoardDAO boardDAO) {
		super();
		this.boardDAO = boardDAO;
	}

	
	// implements 를 했기 때문에 BoardeService까지 오버라이드가 되어있다.
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
