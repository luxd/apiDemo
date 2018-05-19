package com.curveDental.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {

	@Bean
	public DataSource dataSource() {

		// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		// EmbeddedDatabase dataSource =
		// builder.setType(EmbeddedDatabaseType.H2)
		// .addScript("sql/schema.sql").addScript("sql/data.sql").build();

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
		dataSource.setUsername("root");
		dataSource.setPassword("planplus");
		return dataSource;

	}

	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(hibernateProperties());
		builder.scanPackages("com.curveDental");
		return builder.buildSessionFactory();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		// properties.put("hibernate.lazy", "false");
		properties.put("hibernate.hbm2ddl.import_files", "sql/data.sql");
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	/*
	 * @Bean
	 * public DataSource dataSource() {
	 * return new
	 * EmbeddedDatabaseBuilder().generateUniqueName(false).setName("testdb")
	 * .setType(EmbeddedDatabaseType.H2).addDefaultScripts().setScriptEncoding(
	 * "UTF-8")
	 * .ignoreFailedDrops(true).build();
	 * }
	 * 
	 * @Bean
	 * public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
	 * NamedParameterJdbcTemplate namedParamJdbcTemplate = new
	 * NamedParameterJdbcTemplate(
	 * dataSource());
	 * return namedParamJdbcTemplate;
	 * }
	 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	 * EmbeddedDatabase db =
	 * builder.setType(EmbeddedDatabaseType.H2).addScript("sql/schema1.sql")
	 * .addScript("sql/data.sql").build();
	 * return db;
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("org.h2.Driver");
	 * dataSource.setUrl("jdbc:h2:mem:testdb");
	 * dataSource.setUsername("");
	 * dataSource.setPassword("");
	 */
}
