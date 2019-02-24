package pl.com.redpike.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@PropertySources({
		@PropertySource(CookbookApplication.APPLICATION_YML),
		@PropertySource(CookbookApplication.DB_PROPERTIES)
})
@ComponentScan(CookbookApplication.DEFAULT_PACKAGE)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class CookbookApplication extends SpringBootServletInitializer {

	static final String APPLICATION_YML = "classpath:application.yml";
	static final String DB_PROPERTIES = "classpath:db.properties";

	static final String DEFAULT_PACKAGE = "pl.com.redpike.cookbook";

	static {
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
	}

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}
}
