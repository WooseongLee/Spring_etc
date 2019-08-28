package com.app.example.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.example.code.service.CodeService;
import com.app.example.code.vo.CodeVo;
import com.app.example.user.service.UserService;
import com.app.example.user.vo.UserVo;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private CodeService codeService;

	@RequestMapping("user/login")
	public ModelAndView userLogin(ModelAndView mv, String userId, String pwd) {
		Map<String,String> userInfo=new HashMap<String,String>();
		userInfo.put("userId", userId);
		userInfo.put("pwd", pwd);
		UserVo user=userService.userLogin(userInfo);
		
		String msg="로그인 정보를 확인해주세요.";
		String loc="/";
		if(user!=null) {
			mv.setViewName("home");
		}
		else {
			mv.addObject("msg",msg);
			mv.addObject("loc",loc);
			mv.setViewName("common/msg");
		}
		return mv;
	}

	@RequestMapping("user/userDetailEnd")
	public ModelAndView userDetailEnd(String userId,String name,String relCd,String addrCd, String addrName, String mobile, String homeTel, String useYn, ModelAndView mv)
	{
		logger.debug("userId : "+userId);
		logger.debug("name : "+name);
		logger.debug("relCd : "+relCd);
		logger.debug("addrCd : "+addrCd);
		logger.debug("addrName : "+addrName);
		logger.debug("mobile : "+mobile);
		logger.debug("homeTel : "+homeTel);
		logger.debug("insUser : "+name);
		logger.debug("useYn : "+useYn);
		if(useYn==null) {
			useYn="N";
		}
		if(mobile==null) {
			mobile="";
		}
		if(homeTel==null) {
			homeTel="";
		}
		
		Map details=new HashMap();
		details.put("userId", userId);
		details.put("name", name);
		details.put("relCd", relCd);
		details.put("addrCd", Integer.parseInt(addrCd));
		details.put("addrName", addrName);
		details.put("mobile", mobile);
		details.put("homeTel", homeTel);
		details.put("insUser", name);
		details.put("useYn", useYn);
		
		int result=userService.userDetailEnd(details);
		
		String msg="";
		String loc="";

		if(result>0)
		{
			msg="저장에 성공했습니다. 로그인 화면으로 이동합니다.";
			loc="/";
		}
		else
		{
			msg="저장에 실패했습니다. 다시 시도해주세요.";
			loc="/user/userDetail?userId="+userId;
		}
		mv.addObject("msg",msg);
		mv.addObject("loc",loc);
		mv.setViewName("common/msg");
		return mv;
	}
	
	@RequestMapping("user/joinEnd")
	public ModelAndView userJoinEnd(String userId, String pwd, String name, ModelAndView mv) {
		UserVo user=new UserVo();
		user.setId(userId);
		user.setPw(pwd);
		user.setName(name);
		int result=userService.userJoinEnd(user);
		
		String msg="";
		String loc="";
		
		if(result>0) {
			msg="회원가입 성공. 상세정보 작성페이지로 이동합니다.";
			loc="/user/userDetail?userId="+userId;
		}
		else {
			msg="회원가입 실패. 다시 시도해주세요.";
			loc="/";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc",loc);
		mv.setViewName("common/msg");
		return mv;
	}

	@RequestMapping("user/userDetail")
	public ModelAndView userDetail(String userId, ModelAndView mv, Model model) {
		
		List relCodeList= codeService.relCodeList();
		logger.info(relCodeList.toString());
		
		model.addAttribute("relCodeList", relCodeList);
		mv.addObject("userId",userId);
		mv.setViewName("user/userDetail");
		return mv;
	}
	
	@RequestMapping("user/join")
	public String userJoin() {
		return "user/join";
	}

	@RequestMapping("user/checkId")
	@ResponseBody
	public String checkId(@RequestParam(value="ID") String userId) {
        int count = 0;
        String as = "";
//        System.out.println("리퀘스트매핑 진입----userId-->>>" + userId);
        count = userService.checkId(userId);
//        System.out.println("리퀘스트매핑 진입----count-->>>" + count);
        if (count == 0) {
        	as = "Y";
        }else {
        	as = "N";
        }
        return as;
    }
}