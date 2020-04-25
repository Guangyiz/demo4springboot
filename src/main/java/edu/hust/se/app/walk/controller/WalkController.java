package edu.hust.se.app.walk.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import edu.hust.se.app.AppConfig;
import edu.hust.se.app.walk.entity.Userinfo;
import edu.hust.se.app.walk.entity.WalkData;
import edu.hust.se.app.walk.service.IUserinfoService;
import edu.hust.se.app.walk.service.IWalkDataService;
import edu.hust.se.common.util.CalendarUtil;
import edu.hust.se.common.util.JsonView;
import edu.hust.se.wechat.process.WeChatClient;
import edu.hust.se.wechat.process.vo.StepListOpenid;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 用户步数打开数据数据
 */
@Controller
@RequestMapping("/rest/walk")
public class WalkController {
	
	@Autowired
	private IWalkDataService dataService;
	
	@Autowired
	private IUserinfoService userinfoServiceImpl;
	
	/**
	 * 获取加密打卡数据
	 */
	@RequestMapping(value="/encryptWeRunData" , method=RequestMethod.POST)
	@ResponseBody
	public String encryptWeRunData(HttpServletRequest request,String encryptedData, String iv, String code, Integer mystep){
		System.out.println(request.getHeader("serverid"));
		if(StringUtils.isEmpty(encryptedData)||StringUtils.isEmpty(iv)||StringUtils.isEmpty(code)){
			return JsonView.error;
		}
		
		StepListOpenid stepObj = WeChatClient.getStepListOpenid(AppConfig.WECHAT_WALK.getAppId(),
				AppConfig.WECHAT_WALK.getAppSecret(), encryptedData, iv, code);
		
		JsonView jv = new JsonView();
		if(null != stepObj && StringUtils.isNotEmpty(stepObj.getOpenid())){
			String openid = stepObj.getOpenid();
			JSONObject jsObj = new JSONObject();
			jsObj.put("openid", openid);
			
			Integer step = stepObj.getTodayStep();
			jsObj.put("step",step);
			
			Integer nowMonth = CalendarUtil.getMonth();//当前月
			List<WalkData> stepList = new ArrayList<WalkData>();
			for(Object item : stepObj.getSteplist()){
				com.alibaba.fastjson.JSONObject tmpStepObj = (com.alibaba.fastjson.JSONObject)item;
				Long timestamp = tmpStepObj.getLong("timestamp");
				Date tdate = new Date(timestamp*1000);
				Integer tm = CalendarUtil.getMonth(tdate);
				Integer td = CalendarUtil.getDate(tdate);
				if(nowMonth == tm){
					Integer tmpStep = tmpStepObj.getInteger("step");
					WalkData data = new WalkData();
					data.setKdate(td);
					data.setSteps(tmpStep);
							        	
					stepList.add(data);
				}
				jsObj.put("stepList", stepList);
			}
			
			try{
				//获取当前用户
				Userinfo userinfo = userinfoServiceImpl.getOrCreate(openid);
				jsObj.put("userinfo", userinfo);
				
				//和上次打卡数据不一致，上传
				if(!step.equals(mystep)){
					dataService.uploadDakaDaka(userinfo, step);
				}
			}catch(Exception e){
				
			}
			jv.setData(jsObj);
		}
		return jv.toString();
	}
	
	/**
	 * 获取打卡数据
	 */
	@RequestMapping(value="/getCalendarData" ,method=RequestMethod.POST)
	@ResponseBody
	public String getCalendarData(HttpServletRequest request, String openid, Integer year, Integer month){
		if(StringUtils.isEmpty(openid)||null == year||null == month){
			return JsonView.error;
		}
		List<WalkData> list = dataService.getCalendarData(openid, year, month);
		JsonView jv = new JsonView();
		jv.setData(list);
		return jv.toString();
	}
		
}

