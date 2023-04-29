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
		// 온갖 Controller 객체를 HashMap에 등록한다.
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/loggout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
// 위 컨트롤러 종류를 클래스로 하나씩 만들 예정

	}
	public Controller getController(String path) {
		// 요청path Controller 객체를 검색하여 리턴한다.
		return mappings.get(path);
	}

}
