package com.example.demomongodb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("prod")
public class DemoMongodbApplication 
{
	private static final Logger LOG = LoggerFactory.getLogger(DemoMongodbApplication.class);
	
	@Autowired private CounterService counterService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMongodbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(TimezoneDao dao)
	{
		return args ->
		{
			dao.deleteAll();
			
			TimeZone tz = new TimeZone();
			tz.setId(counterService.getNextSequence());
			tz.setTz("Europe/London");
			tz.setOffset(0);
			
			TimeZone tz2 = new TimeZone();
			tz2.setId(counterService.getNextSequence());
			tz2.setTz("Europe/Amsterdam");
			tz2.setOffset(1);
			
			TimeZone tz3 = new TimeZone();
			tz3.setId(counterService.getNextSequence());
			tz3.setTz("US/New_York");
			tz3.setOffset(-5);
			
			TimeZone tz4 = new TimeZone();
			tz4.setId(counterService.getNextSequence());
			tz4.setTz("Europe/Zurich");
			tz4.setOffset(1);
			
			dao.save(tz);
			dao.save(tz2);
			dao.save(tz3);
			dao.save(tz4);
			
			List<TimeZone> tzs = new ArrayList<>();
			dao.findAll().forEach(tzs::add);
			
			for(TimeZone t : tzs)
			{
				LOG.info("Retrieved {}", t.toString());
			}
		};
	}
}
