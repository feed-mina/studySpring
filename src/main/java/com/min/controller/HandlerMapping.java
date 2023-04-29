package com.min.controller;

import java.util.HashMap;
import java.util.Map;

import com.min.controller.board.DeleteBoardController;
import com.min.controller.board.GetBoardController;
import com.min.controller.board.GetBoardListController;
import com.min.controller.board.InsertBoardController;
import com.min.controller.board.UpdateBoardController;
import com.min.controller.user.LoginController;
import com.min.controller.user.LogoutController;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		// �°� Controller ��ü�� HashMap�� ����Ѵ�.
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/loggout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
// �� ��Ʈ�ѷ� ������ Ŭ������ �ϳ��� ���� ����

	}
	public Controller getController(String path) {
		// ��ûpath Controller ��ü�� �˻��Ͽ� �����Ѵ�.
		return mappings.get(path);
	}

}
