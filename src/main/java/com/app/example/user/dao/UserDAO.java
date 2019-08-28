package com.app.example.user.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.app.example.user.vo.UserVo;

public interface UserDAO {

	UserVo userLogin(SqlSessionTemplate session, Map userInfo);
	int checkId(SqlSessionTemplate session, String userId);
	int userJoinEnd(SqlSessionTemplate session, UserVo user);
	int userDetailEnd(SqlSessionTemplate session, Map details);
	String getMaxCodeNo(SqlSessionTemplate session, String cdno);
}
