package com.app.example.user.service;

import java.util.Map;

import com.app.example.user.vo.UserVo;

public interface UserService {
	UserVo userLogin(Map userInfo);
	int checkId(String userId);
	int userJoinEnd(UserVo user);
	int userDetailEnd(Map details);
}
