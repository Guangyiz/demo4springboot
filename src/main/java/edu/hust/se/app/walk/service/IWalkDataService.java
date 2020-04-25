package edu.hust.se.app.walk.service;

import edu.hust.se.app.walk.entity.Userinfo;
import edu.hust.se.app.walk.entity.WalkData;
import edu.hust.se.wechat.process.vo.StepListOpenid;

import java.util.List;



public interface IWalkDataService {
	
	//上传打卡数据
	void uploadDakaDaka(Userinfo userinfo, Integer step);
	
	//获取打卡数据
	List<WalkData> getCalendarData(String openid, Integer year, Integer month);
	
	//补打卡数据
	List<WalkData> resignCalendarData(Userinfo userinfo, StepListOpenid stepObj, Integer year, Integer month);
	
	void create(WalkData entity);

	void update(WalkData entity);

	void delete(WalkData entity);

}
