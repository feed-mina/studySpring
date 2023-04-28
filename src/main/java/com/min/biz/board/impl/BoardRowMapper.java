package com.min.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.min.biz.board.BoardVO;


// select 객체를 어떤 자바객체에 맵핑할것인지가 관건 , rowMapper 는 select 만 필요 / 등록,수정,삭제는 rowMapper가 필요 없다.

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		// 검색 결과가 저장된 ResultSet의 각 Row를 어떤 자바 객체 (VO)와 어떻게 매핑할 것인지를 기술한다.
		
		
		System.out.println("rowNum--- : " + rowNum);
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setCnt(rs.getInt("CNT"));
		return board;
		
	}
}
