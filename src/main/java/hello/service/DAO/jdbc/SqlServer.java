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
        dataSource.setUrl("jdbc:sqlserver://123.192.97.36:1433;databaseName=master");//databaseName=TutorialDB
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUsername("sa");//test1
        dataSource.setPassword("123weR456");//1234567
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static JdbcTemplate getSqlserverInstance() {
		
		return jdbcTemplate;
	}
	
	
}
