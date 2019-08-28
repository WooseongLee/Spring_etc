package com.app.example.code.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.example.code.service.CodeService;

@Controller
public class CodeController {

	private static final Logger logger = LoggerFactory.getLogger(CodeController.class);

	@Autowired
	private CodeService codeService;

	@RequestMapping("code/codeManager")
	public ModelAndView codeMng(ModelAndView mv) {
		List<Map> codes=codeService.codeListAll();
		mv.addObject("codes",codes);
		mv.setViewName("code/codeManager");
		return mv;
	}
	
	@RequestMapping("code/getMaxCodeNo")
	@ResponseBody
	public String getMaxCodeNo(String cdno) {
		String maxCodeNo = codeService.getMaxCodeNo(cdno);
		return maxCodeNo;
	}
}