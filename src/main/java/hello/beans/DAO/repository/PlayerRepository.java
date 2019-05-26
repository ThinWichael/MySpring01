package hello.beans.DAO.repository;
import org.springframework.data.repository.CrudRepository;
import hello.beans.DAO.Player;

public interface PlayerRepository extends CrudRepository<Player,Integer> {
   // can add by yourself, like "Player findByYourColumn()"
   Player findByName(String name);     
}
