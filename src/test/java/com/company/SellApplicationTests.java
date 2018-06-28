package com.company;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellApplicationTests {

//	protected Logger logger = LoggerFactory.getLogger(SellApplicationTests.class);

	@Test
	public void contextLoads() {

		log.info("info.......");
		log.error("error.......");
		log.debug("debug......");
		log.warn("warn......");
		String name = "zhangsan";
		String city = "shanghai";
		log.info("info:{},city:{}",name,city);
	}

}
