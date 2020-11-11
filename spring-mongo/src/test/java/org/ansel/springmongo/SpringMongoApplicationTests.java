package org.ansel.springmongo;

import org.ansel.springmongo.utils.QuestionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class SpringMongoApplicationTests {

	private MongoTemplate mongoTemplate;

	@Autowired
	private SpringMongoApplicationTests(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Test
	void contextLoads() {
		for (int i = 0; i < 1000; i++) {
			mongoTemplate.save(QuestionUtils.generateRandomQuestion(), "quizquestions");
		}

	}

}
