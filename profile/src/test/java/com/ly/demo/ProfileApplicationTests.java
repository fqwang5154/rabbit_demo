package com.ly.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("en")
public class ProfileApplicationTests {

	@Autowired
	private Persion p;
	
	@Test
	public void contextLoads() {
		p.speak();
	}

}
