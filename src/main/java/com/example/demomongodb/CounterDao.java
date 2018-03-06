package com.example.demomongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CounterDao extends MongoRepository<Counter, String>{
	Counter findTopByOrderByIdDesc();
}
