package hello.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = AuthorizationService.class)
@RunWith(SpringRunner.class)

public class AuthorizationServiceTest {

	@MockBean
	AuthorizationService authorizationService;

	@Test
	public void test() {
		
		when(authorizationService.checktest()).thenReturn("test OK!");
		System.out.println("~~~~ AuthorizationServiceTest ~~~~~");
	}

}
