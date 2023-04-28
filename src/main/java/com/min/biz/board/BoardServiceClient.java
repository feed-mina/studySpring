package com.min.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. �׽�Ʈ�� ��ü�� Lookup�Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		if(boardService != null) {
			System.out.println(boardService + "��ü �˻� ���� !");
		}
		// 3. Lookup �� ��ü�� �׽�Ʈ�Ѵ�.
		BoardVO vo = new BoardVO();
		// vo.setSeq(0);
		vo.setTitle("�ӽ� ����");
		vo.setWriter("�׽���");
		vo.setContent("�ӽ� ����............");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		// 4. ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}

}
