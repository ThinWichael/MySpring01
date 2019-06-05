package hello.service.DAO.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class SqlServer {
	JdbcTemplate jdbcTemplate;
	
	@Value("${spring.datasource.url}")
	String DB_URL;
	
	@Value("${spring.datasource.username}")
	String USER;
	
	@Value("${spring.datasource.password}")
	String PWD;
	
	public SqlServer() {
		// TODO Auto-generated constructor stub
	}
	
	public JdbcTemplate getSqlserverInstance() {
		if(jdbcTemplate == null) {
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
	        dataSource.setUrl(DB_URL);//databaseName=TutorialDB
	        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        dataSource.setUsername(USER);//test1
	        dataSource.setPassword(PWD);//1234567
	        jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}
	
	
}
