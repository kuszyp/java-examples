package pl.myapp.java.examples.database.springJdbc;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
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

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
