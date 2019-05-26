package hello.service.DAO.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class SqlServer {
	static JdbcTemplate jdbcTemplate;
	public SqlServer() {
		// TODO Auto-generated constructor stub
	}

	static {	
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=TutorialDB");
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUsername("test1");
        dataSource.setPassword("1234567");
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static JdbcTemplate getSqlserverInstance() {
		
		return jdbcTemplate;
	}
	
	
}
