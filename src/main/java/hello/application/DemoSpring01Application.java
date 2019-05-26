package hello.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "hello") // if your controller not in same package with this class
// you need to use componentScan to include it
public class DemoSpring01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring01Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoSpring01Application.class);
	}
}

