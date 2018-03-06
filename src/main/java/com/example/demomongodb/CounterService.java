package com.example.demomongodb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CounterService 
{
	@Autowired private CounterDao dao;
	
	@PostConstruct
	private void init()
	{
		dao.deleteAll();
	}
	
	public int getNextSequence() 
	{
		Counter last = dao.findTopByOrderByIdDesc();
	    int lastNum = last == null? -1 : last.getSeq();
	    Counter next = new Counter();
	    next.setSeq(lastNum + 1);
	    dao.save(next);
	    return next.getSeq();
	  }
}
