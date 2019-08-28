package com.app.example.code.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDAOImpl implements CodeDAO {

	@Override
	public String getMaxCodeNo(SqlSessionTemplate session, String cdno) {
		return session.selectOne("code.getMaxCodeNo", cdno);
	}

	@Override
	public List<Map> codeListAll(SqlSessionTemplate session) {
		return session.selectList("code.codeListAll");
	}

	@Override
	public List<Map> relCodeList(SqlSessionTemplate session) {
		return session.selectList("code.relCodeList");
	}

	@Override
	public int insertCode(SqlSessionTemplate session, Map code) {
		return session.insert("code.insertCode",code);
	}

	@Override
	public int updateCode(SqlSessionTemplate session, Map code) {
		return session.update("code.updateCode",code);
	}

	@Override
	public List<Map> madeCodeList(SqlSessionTemplate session) {
		return session.selectList("code.madeCodeList");
	}

	@Override
	public List<Map> unitCodeList(SqlSessionTemplate session) {
		return session.selectList("code.unitCodeList");
	}

	@Override
	public List<Map> cateCodeList(SqlSessionTemplate session) {
		return session.selectList("code.cateCodeList");
	}

	@Override
	public List<Map> groupList(SqlSessionTemplate session, String catecode) {
		return session.selectList("code.groupList",catecode);
	}
}