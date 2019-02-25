package pl.com.redpike.cookbook.configuration.jpa;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import pl.com.redpike.cookbook.data.book.BookRepository;
import pl.com.redpike.cookbook.data.category.CategoryRepository;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = {
                BookRepository.class,
                CategoryRepository.class
        },
        entityManagerFactoryRef = "cookbookEntityManager",
        transactionManagerRef = "cookbookTransactionManager"
)
public class CookBookJPAConfiguration {

    private static final String PROPERTIES_PREFIX = "cookbook.datasource";

    private static final String DEFAULT_PACKAGE = "pl.com.redpike.cookbook.data.";
    private static final String BOOK_PACKAGE = DEFAULT_PACKAGE + "book";
    private static final String CATEGORY_PACKAGE = DEFAULT_PACKAGE + "category";

    @Bean
    public LocalContainerEntityManagerFactoryBean cookbookEntityManager() {
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setPackagesToScan(
                BOOK_PACKAGE,
                CATEGORY_PACKAGE
        );
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        managerFactoryBean.setJpaProperties(additionalProperties());

        return managerFactoryBean;
    }

    @Bean
    @ConfigurationProperties(prefix = PROPERTIES_PREFIX)
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager cookbookTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(cookbookEntityManager().getObject());
        return transactionManager;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); // TODO For development

        return properties;
    }
}
