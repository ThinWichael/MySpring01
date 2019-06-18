package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hello.application.DemoSpring01Application;

@RunWith(SpringJUnit4ClassRunner.class) // spring boot test
@SpringBootTest(classes = DemoSpring01Application.class) // spring boot test
@ComponentScan(basePackages = {"hello.controller","hello.beans.restful"})
public class DemoSpring01ApplicationTests {
	
	@Before
	public void setup() {
	
	}
	
	@Test
	public void contextLoads() {
		
	}

}

