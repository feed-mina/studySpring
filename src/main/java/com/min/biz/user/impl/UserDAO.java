package com.min.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.min.biz.common.JDBCUtil;
import com.min.biz.user.UserVO;

@Repository // DAO�� repository ������̼�
public class UserDAO  {

// JDBC ���� ����	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL ���ɾ��
	private final String USER_GET = "select * from users where id =? and password =?";
	
	
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("==> JDBC�� getUser() ���ó��");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}