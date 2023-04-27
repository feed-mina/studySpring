package com.min.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.biz.user.UserService;
import com.min.biz.user.UserVO;

// Service 구현 클래스
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired //type injection
	private UserDAO userDAO;

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
			}

}
