package pl.com.redpike.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@ComponentScan(CookbookApplication.DEFAULT_PACKAGE)
@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class CookbookApplication extends SpringBootServletInitializer {

	static final String DEFAULT_PACKAGE = "pl.com.redpike.cookbook";

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}
}
