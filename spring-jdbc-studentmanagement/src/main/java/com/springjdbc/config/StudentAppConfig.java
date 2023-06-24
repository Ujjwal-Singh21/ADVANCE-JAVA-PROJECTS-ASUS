package com.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.springjdbc" })
public class StudentAppConfig implements WebMvcConfigurer {

	// VIEW RESOLVER
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// DATASOURCE
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}

	// JDBC TEMPLATE CLASS
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}

	// MAKE URL PATH TO RESOURCES FOLDER TO ADD IMAGE/CSS/JS i.e) STATIC RESOURCES
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// for css folder
		registry
		.addResourceHandler("/UrltoReachResourcesFolder/**")
		.addResourceLocations("/resources/");
		
		// for images folder
		registry.addResourceHandler("/UrltoReachImagesFolder/**")
		.addResourceLocations("/resources/images/");
	}

}
