package com.min.biz.board;

import java.util.List;

// 3. alt + shift + T : interface extract BoardService => selectAll => implements BoardService �� ���� �׷��� ���� �ۼ�
public interface BoardService {

	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);

	// �� ��� ��ȸ
	// ����ִ� List ��ü�� while������ �����鼭 �����͸� �����´�. 
	List<BoardVO> getBoardList(BoardVO vo);

}