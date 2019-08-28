package com.app.example.code.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.example.code.dao.CodeDAO;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeDAO dao;
	@Autowired
	private SqlSessionTemplate session;
	@Override
	public String getMaxCodeNo(String cdno) {
		return dao.getMaxCodeNo(session, cdno);
	}
	@Override
	public List<Map> codeListAll() {
		return dao.codeListAll(session);
	}
	@Override
	public List<Map> relCodeList() {
		return dao.relCodeList(session);
	}
	@Override
	public int insertCode(Map code) {
		return dao.insertCode(session,code);
	}
	@Override
	public int updateCode(Map code) {
		return dao.updateCode(session,code);
	}
	@Override
	public List<Map> madeCodeList() {
		return dao.madeCodeList(session);
	}
	@Override
	public List<Map> unitCodeList() {
		return dao.unitCodeList(session);
	}
	@Override
	public List<Map> cateCodeList() {
		return dao.cateCodeList(session);
	}
	@Override
	public List<Map> groupList(String catecode) {
		return dao.groupList(session,catecode);
	}
	
	
	
}