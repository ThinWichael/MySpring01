package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import hello.beans.DAO.Player;
import hello.beans.DAO.repository.PlayerRepository;

@Service
@EntityScan(basePackages = {"hello.beans.DAO"} )
@EnableJpaRepositories(basePackages = {"hello.beans.DAO.repository"})

public class RegisterUseCase {
	@Autowired
	private PlayerRepository playerRepository;
	
//	@Autowired
//	public RegisterUseCase(PlayerRepository playerRepository) {
//		// TODO Auto-generated constructor stub
//		this.playerRepository = playerRepository;
//	}

	public Player registerPlayer(Player player) {
		return playerRepository.save(player);
	}
	
}
