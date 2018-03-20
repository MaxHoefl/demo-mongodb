package com.example;

import java.io.IOException;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;


@Profile("test")
@SpringBootConfiguration
@ComponentScan(basePackages= {"com.example.demomongodb"})
@EnableMongoRepositories(basePackages= {"com.example.demomongodb"})
@EnableAutoConfiguration
@AutoConfigureDataMongo
public class MongoConfig 
{
	public MongoConfig()
	{
		System.out.println("============= LOADING MONGO CONFIG ===============");
	}
	
//	@Bean
//	public MongoTemplate mongoTemplate() throws IOException {
//	    EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//	    mongo.setBindIp("localhost");
//	    MongoClient mongoClient = mongo.getObject();
//	    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "test_or_whatever_you_want_to_call_this_db");
//	    return mongoTemplate;
//	}
	
	@Bean(destroyMethod="close")
	public Mongo mongo() throws IOException {
	    return new EmbeddedMongoBuilder()
	        .version("2.4.5")
	        .bindIp("127.0.0.1")
	        .port(30000)
	        .build();
	}
}
