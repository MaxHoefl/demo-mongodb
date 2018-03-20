package com.example.demomongodb;

import static org.junit.Assert.*;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MongoConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MongoConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class Test_TimezoneDao {

	private static final Logger LOG = LoggerFactory.getLogger(Test_TimezoneDao.class);
	
	//@Autowired private TimezoneDao dao;
	@Autowired private CounterService counterService;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void test() 
	{
		TimeZone tz = new TimeZone();
		tz.setId(counterService.getNextSequence());
		tz.setOffset(9);
		tz.setTz("Asia/Singapore");
		
		TimeZone tz2 = new TimeZone();
		tz2.setId(counterService.getNextSequence());
		tz2.setOffset(11);
		tz2.setTz("Australia/Sydney");
		
		mongoTemplate.save(tz);
		
		List<TimeZone> tzs = mongoTemplate.findAll(TimeZone.class, "timezones");
		
		for(TimeZone t : tzs)
		{
			LOG.info(t.toString());
		}
	}
}
