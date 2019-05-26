package hello.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import hello.tools.ConfigUtil;

@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class MySpringConfig {
	
	private String path;
	ConfigUtil cu ;
    private String HOST;
    private String PORTAL;
	
	public MySpringConfig() {
		
		// TODO Auto-generated constructor stub
	}

	public void setUp() {
		this.cu = new ConfigUtil(path);
		this.HOST = cu.getString("set1.host");
		this.PORTAL = cu.getString("set1.portal");
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
