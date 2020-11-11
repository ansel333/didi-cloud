package org.ansel.springmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoConfig {

	// private final MongoDatabaseFactory mongo;
	private final MongoTemplate mongoTemplate;

	@Autowired
	public MongoConfig(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		// this.mongo=null;
	}
}
