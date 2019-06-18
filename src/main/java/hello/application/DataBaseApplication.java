package hello.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import hello.beans.DAO.Customer;

import hello.constant.MySpringConfig;
import hello.service.DAO.jdbc.SqlServer;

/* This is a test commandLine application*/
// ****** legacy for this project ******

//@SpringBootApplication(scanBasePackages = { "hello" })
public class DataBaseApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DataBaseApplication.class);
//	ConfigConstants configConstants;
	@Autowired
	MySpringConfig mySpringConfig;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DataBaseApplication.class, args);
	}

	@Autowired
	SqlServer sqlserver;
	private JdbcTemplate jdbcTemplate = sqlserver.getSqlserverInstance();

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub.
		mySpringConfig.setUp();
		log.info("===HOST=== " + mySpringConfig.getPath());
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
		jdbcTemplate.execute(" CREATE TABLE [customers]("
		        + "[id] [int] IDENTITY(1,1) NOT NULL,"
				+ "[first_name] [NVARCHAR](50), "
				+ "[last_name] [VARCHAR](50)) ON [PRIMARY]");

		List<Object[]> splitName = Arrays.asList("Bonnie Lin", "Jeff Sue", "Josh Bleach", "Josh Liang").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		splitName.forEach(e -> log.info(String.format("Inserting" + "customer record for %s %s", e[0], e[1])));
		// batchUpdate to bulk insert data
		jdbcTemplate.batchUpdate("INSERT INTO customers(" + "first_name, last_name) VALUES (?,?)", splitName);

		log.info("Query customer records where first_name = 'josh'");
		jdbcTemplate
				.query("SELECT id, first_name, last_name FROM customers "
		             + "WHERE first_name = ?",new Object[] { "josh" }
		             , (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		             ).forEach(customer -> log.info(customer.toString()));

	}

}
