package com.app.example.code.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface CodeDAO {

	List<Map> codeListAll(SqlSessionTemplate session);
	List<Map> relCodeList(SqlSessionTemplate session);
	int insertCode(SqlSessionTemplate session, Map code);
	int updateCode(SqlSessionTemplate session, Map code);
	List<Map> madeCodeList(SqlSessionTemplate session);
	List<Map> unitCodeList(SqlSessionTemplate session);
	List<Map> cateCodeList(SqlSessionTemplate session);
	List<Map> groupList(SqlSessionTemplate session, String catecode);
	String getMaxCodeNo(SqlSessionTemplate session, String cdno);
}
