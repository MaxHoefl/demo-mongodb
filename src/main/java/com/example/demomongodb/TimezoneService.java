package com.example.demomongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimezoneService 
{
	@Autowired private TimezoneDao dao;
	@Autowired private CounterService counterService;
	
	public List<TimeZone> getAll()
	{
		return dao.findAll();
	}
	
	public TimeZone save(TimeZone tz)
	{
		tz.setId(counterService.getNextSequence());
		return dao.save(tz);
	}
	
	public void deleteAll()
	{
		dao.deleteAll();
	}
}
