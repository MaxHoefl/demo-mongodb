package com.example.demomongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimezoneDao extends MongoRepository<TimeZone, Long>
{
}
