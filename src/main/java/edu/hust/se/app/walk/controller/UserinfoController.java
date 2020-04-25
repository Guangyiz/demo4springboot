package edu.hust.se.app.walk.controller;

import javax.servlet.http.HttpServletRequest;

import edu.hust.se.app.walk.entity.Userinfo;
import edu.hust.se.app.walk.service.IUserinfoService;
import edu.hust.se.common.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 获取用户相关数据
 */
@Controller
@RequestMapping("/rest/user")
public class UserinfoController {
	
	@Autowired
	private IUserinfoService userinfoServiceImpl;
	
	/**
	 * 更新用户信息
	 */
	@RequestMapping(value="/updateUserinfo" , method=RequestMethod.POST)
	@ResponseBody
	public String updateUserinfo(HttpServletRequest request, Userinfo userinfo){
		if(StringUtils.isEmpty(userinfo.getOpenid())){
			return JsonView.error;
		}
		userinfoServiceImpl.updateUserinfoByOpenid(userinfo);
		return new JsonView().toString();
	}
	
}

