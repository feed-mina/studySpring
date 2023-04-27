package com.min.biz.board;

import java.util.List;

// 3. alt + shift + T : interface extract BoardService => selectAll => implements BoardService 가 생김 그러나 따로 작성
public interface BoardService {

	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	// 비어있는 List 객체에 while루프를 돌리면서 데이터를 가져온다. 
	List<BoardVO> getBoardList(BoardVO vo);

}