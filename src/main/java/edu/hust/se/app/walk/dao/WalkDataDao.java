package edu.hust.se.app.walk.dao;

import edu.hust.se.app.walk.entity.WalkData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WalkDataDao {
	
	public void create(WalkData entity);
	
	public void update(WalkData entity);
	
	public void delete(WalkData entity);
	
	public WalkData getTodayData(WalkData queryEntity);
	
	public List<WalkData> getCalendarData(WalkData queryEntity);
	
	public void insertBatch(List<WalkData> list);

}

