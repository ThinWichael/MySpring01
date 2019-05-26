package hello.beans.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA annotation
@Table(name = "player_tbl") // JPA annotation
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // for Chinese , use nvarchar type
    @Column(name = "name", nullable = false , columnDefinition="nvarchar(50)")
    private String name;
    private int age;
    
    public Player() {
    }
    
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player{" +
				"name='" + name + '\'' +
				", Age=" + age + 
				'}';
	}

}
