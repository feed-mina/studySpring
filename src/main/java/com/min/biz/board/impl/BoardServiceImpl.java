package com.min.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;


// 4. Service ���� Ŭ���� : �����������̽��� implements �� ServiceImpl Ŭ������ �ۼ�

// @Component("boardService") // id�� @Component("id�̸�") ���� �־�� �Ѵ�. 
//@Component : ����Ͻ� ������ ó���ϴ� ServiceŬ���������� @Component ������̼� ���  @Service �� ����ϴ°� ���� 

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // Type Injection
	private BoardDAO boardDAO;

	
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
