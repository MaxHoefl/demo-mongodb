package com.example.demomongodb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest(includeFilters = @Filter(Service.class))
//@ComponentScan({"com.example.demomongodb"})
@ActiveProfiles("test")
public class Test_TimezoneDao {

	@Autowired private TimezoneDao dao;
	@Autowired private CounterService counterService;

	@Test
	public void test() {
		
	}

}
