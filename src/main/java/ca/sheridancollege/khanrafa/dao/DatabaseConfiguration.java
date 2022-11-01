package ca.sheridancollege.khanrafa.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DatabaseConfiguration {

//Used in the DatabaseAccess class to submit JDBC parametric query Strings
@Bean
public NamedParameterJdbcTemplate
	namedParemterJdbcTemplate(DataSource dataSource) {
	      return new NamedParameterJdbcTemplate(dataSource);
	}
}