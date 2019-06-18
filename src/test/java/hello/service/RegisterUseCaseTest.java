package hello.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hello.application.DemoSpring01Application;
import hello.beans.DAO.Player;
import hello.beans.DAO.repository.PlayerRepository;

//@SpringBootTest(classes = DemoSpring01Application.class)
//@RunWith(SpringRunner.class)
@EntityScan(basePackages = {"hello.beans.DAO"} )
@EnableJpaRepositories(basePackages = {"hello.beans.DAO.repository"})
public class RegisterUseCaseTest {
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private RegisterUseCase registerUseCase;
	
	
	
	@Before
	public void initUseCase() {
//		registerUseCase = new RegisterUseCase(playerRepository);
	
	}

	@Test
	public void test() {
		Player player1 = new Player("rkPost", 42);
		Player savedPlayer = registerUseCase.registerPlayer(player1);
		
		assertEquals(savedPlayer.getName(),"rkPost");
	}

}
