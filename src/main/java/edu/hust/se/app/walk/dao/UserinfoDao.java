package edu.hust.se.app.walk.dao;

import edu.hust.se.app.walk.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserinfoDao {
	
	public List<Userinfo> queryTodayRank();
	
	public List<Userinfo> queryMonthRank();

	public List<Userinfo> queryAllRank();
	
	public void resetTodayStep();
	
	public void resetMonthStep();
	
	public Userinfo getByOpenid(String openid);

	public void create(Userinfo entity);

	public void update(Userinfo entity);
	
	public void updateUserinfoByOpenid(Userinfo userinfo);

	public void delete(Userinfo entity);

}

