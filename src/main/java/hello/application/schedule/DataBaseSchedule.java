package hello.application.schedule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import hello.beans.DAO.Customer;
import hello.constant.MySpringConfig;
import hello.service.DAO.jdbc.SqlServer;

@Configuration
@EnableScheduling
public class DataBaseSchedule {

	private static Logger logger = Logger.getLogger(DataBaseSchedule.class);
	
	@Autowired
	MySpringConfig mySpringConfig;
	
	@Autowired
	SqlServer sqlserver;
	private JdbcTemplate jdbcTemplate ;
	
	public DataBaseSchedule() {
		// TODO Auto-generated constructor stub
		logger.info("~~~~~~~~ constructor ~~~~~~~~");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("~~~~~~~~ Start ~~~~~~~~");
		jdbcTemplate = sqlserver.getSqlserverInstance();
		buildDBtable();
	}
	
	public void buildDBtable() {
		logger.info("~~~~~~~~~~~~~scheduling~~~~~~~~~~~~~");
		
		mySpringConfig.setUp();
		logger.info("===HOST=== " + mySpringConfig.getPath());
		logger.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
		jdbcTemplate.execute(" CREATE TABLE [customers]("
		        + "[id] [int] IDENTITY(1,1) NOT NULL,"
				+ "[first_name] [NVARCHAR](50), "
				+ "[last_name] [VARCHAR](50)) ON [PRIMARY]");

		List<Object[]> splitName = Arrays.asList("Bonnie Lin", "Jeff Sue", "Josh Bleach", "Josh Liang").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		splitName.forEach(e -> logger.info(String.format("Inserting" + "customer record for %s %s", e[0], e[1])));
		// batchUpdate to bulk insert data
		jdbcTemplate.batchUpdate("INSERT INTO customers(" + "first_name, last_name) VALUES (?,?)", splitName);

		logger.info("Query customer records where first_name = 'josh'");
		jdbcTemplate
				.query("SELECT id, first_name, last_name FROM customers "
		             + "WHERE first_name = ?",new Object[] { "josh" }
		             , (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		             ).forEach(customer -> logger.info(customer.toString()));
	}
}
//public static doSomethings(){}
//@Scheduled(fixedDelay = 1000) //Schedule a Task at Fixed Delay
//@Scheduled(fixedRate = 1000) //Schedule a Task at a Fixed Rate
//@Scheduled(fixedDelay = 1000, initialDelay = 1000) //Schedule a Task with Initial Delay

//@Scheduled(cron = "0 15 10 15 * ?") //Schedule a Task using Cron Expressions
//A task to be executed at 10:15 AM on the 15th day of every month

//@EventListener(ApplicationReadyEvent.class)
//@EventListener(ContextRefreshedEvent.class)
//Someone may also wish to use @EventListener(ContextRefreshedEvent.class) instead, which 
//gets triggered after bean creation, but before the server starts. It can be used to perform 
//activities before any requests hit the server
