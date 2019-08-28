package com.app.example.user.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.example.user.dao.UserDAO;
import com.app.example.user.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public UserVo userLogin(Map userInfo) {
		return dao.userLogin(session,userInfo);
	}

	@Override
	public int checkId(String userId) {
		return dao.checkId(session,userId);
	}

	@Override
	public int userJoinEnd(UserVo user) {
		return dao.userJoinEnd(session,user);
	}

	@Override
	public int userDetailEnd(Map details) {
		return dao.userDetailEnd(session, details);
	}
}
