package com.app.example.code.service;

import java.util.List;
import java.util.Map;

public interface CodeService {

	List<Map> codeListAll();
	List<Map> relCodeList();
	int insertCode(Map code);
	int updateCode(Map code);
	List<Map> madeCodeList();
	List<Map> unitCodeList();
	List<Map> cateCodeList();
	List<Map> groupList(String catecode);
	String getMaxCodeNo(String cdno);
}
