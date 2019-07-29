package com.example.beans.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import hello.application.DemoSpring01Application;
import hello.beans.DAO.Player;
import hello.beans.DAO.repository.PlayerRepository;

//@SpringBootTest(classes = DemoSpring01Application.class)
//@RunWith(SpringRunner.class)
//*** If your entity and Hibernet repository are at 'different' package, USE below annotation !!!!
@EntityScan(basePackages = {"hello.beans.DAO"} )
@EnableJpaRepositories(basePackages = {"hello.beans.DAO.repository"})

public class PlayerRepositoryTest {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Before
	public void setUp() {
		Player p1 = new Player("Tom", 22);
		Player p2 = new Player("Kate", 30);
		Player p3 = new Player("Amy", 30);
		assertNull(p1.getId());
		assertNull(p2.getId());
		this.playerRepository.save(p1);
		this.playerRepository.save(p2);
		this.playerRepository.save(p3);
		assertNotNull(p1.getId());
		assertNotNull(p2.getId());
	}
	@Test
	public void testFetchData() {
		Player p1 = playerRepository.findByName("Tom");
		Player p3 = playerRepository.findByName("Amy");

		assertNotNull(p1);
		assertEquals(22, p1.getAge());
		
		// Get all players
		Iterable<Player> players = playerRepository.findAll();
		
		int count = 0;
		for(Player p: players) {
			count++;
		}
		assertEquals(count, 3);
	}

}
