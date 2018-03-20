package com.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.example.demomongodb.TimeZone;
import com.example.demomongodb.TimezoneService;

@SpringBootApplication
@ActiveProfiles("prod")
@ComponentScan
public class DemoMongodbApplication 
{
	private static final Logger LOG = LoggerFactory.getLogger(DemoMongodbApplication.class);
	
	@Autowired private TimezoneService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMongodbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init()
	{
		return args ->
		{
			service.deleteAll();
			
			TimeZone tz = new TimeZone();
			tz.setTz("Europe/London");
			tz.setOffset(0);
			
			TimeZone tz2 = new TimeZone();
			tz2.setTz("Europe/Amsterdam");
			tz2.setOffset(1);
			
			TimeZone tz3 = new TimeZone();
			tz3.setTz("US/New_York");
			tz3.setOffset(-5);
			
			TimeZone tz4 = new TimeZone();
			tz4.setTz("Europe/Zurich");
			tz4.setOffset(1);
			
			service.save(tz);
			service.save(tz2);
			service.save(tz3);
			service.save(tz4);
			
			List<TimeZone> tzs = service.getAll();
			
			for(TimeZone t : tzs)
			{
				LOG.info("Retrieved {}", t.toString());
			}
		};
	}
}
