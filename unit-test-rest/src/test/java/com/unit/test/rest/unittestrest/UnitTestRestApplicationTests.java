package com.unit.test.rest.unittestrest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class UnitTestRestApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(UnitTestRestApplicationTests.class);
	
	@Test
	void contextLoads() {
		logger.debug("LOG MESSAGE");
	}

}
