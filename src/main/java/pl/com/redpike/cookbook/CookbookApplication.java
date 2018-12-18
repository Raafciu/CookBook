package pl.com.redpike.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(CookbookApplication.DEFAULT_PACKAGE)
@SpringBootApplication
public class CookbookApplication extends SpringBootServletInitializer {

	static final String DEFAULT_PACKAGE = "pl.com.redpike.cookbook";

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}
}
