package com.min.biz.user;


// 3. Service 인터페이스 : 추상매서드 하나 포함
public interface UserService {
	//CRUD 기능의 메소드 구현
	// 회원 등록
	UserVO getUser(UserVO vo);

}