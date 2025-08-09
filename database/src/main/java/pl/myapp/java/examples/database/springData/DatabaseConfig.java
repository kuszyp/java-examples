package pl.myapp.java.examples.database.springData;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories
public class DatabaseConfig extends AbstractJdbcConfiguration {
    private final Environment environment;

    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("jdbc.datasource.url"));
        dataSource.setUsername(environment.getProperty("jdbc.datasource.username"));
        dataSource.setPassword(environment.getProperty("jdbc.datasource.password"));
        return dataSource;
    }

//    public EntityManagerFactory entityManagerFactory() {
//        EntityManagerFactory emf = new LocalContainerEntityManagerFactoryBean();
//        return null;
//    }


    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
