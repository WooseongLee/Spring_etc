package com.app.example.user.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.app.example.user.vo.UserVo;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public UserVo userLogin(SqlSessionTemplate session, Map userInfo) {
		return session.selectOne("user.userLogin",userInfo);
	}

	@Override
	public int checkId(SqlSessionTemplate session, String userId) {
		return session.selectOne("user.checkId",userId);
	}

	@Override
	public int userJoinEnd(SqlSessionTemplate session, UserVo user) {
		return session.insert("user.userJoinEnd",user);
	}

	@Override
	public int userDetailEnd(SqlSessionTemplate session, Map details) {
		return session.insert("user.userDetailEnd",details);
	}
	
	@Override
	public String getMaxCodeNo(SqlSessionTemplate session, String cdno) {
		return session.selectOne("code.getMaxCodeNo",cdno);
	}
}
