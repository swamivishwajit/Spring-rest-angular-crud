package com.spring.angular.rest.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.angular.rest.dao.StudentDao;
import com.spring.angular.rest.daoimpl.StudentDaoImpl;
import com.spring.angular.rest.service.StudentService;
import com.spring.angular.rest.serviceimpl.StudentServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.spring.angular.rest")
public class SpringConfiguration extends WebMvcConfigurerAdapter{

	
	@Bean
	public StudentService getStudentService()
	{
		return new StudentServiceImpl();
	}
	
	
	@Bean
	public StudentDao getStudentDao()
	{
		return new StudentDaoImpl();
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.spring.angular.rest.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
	 @Bean
	    public DriverManagerDataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/restcrud");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }
	     
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        properties.put("hibernate.show_sql", true);
	        properties.put("hibernate.format_sql", true);
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        
	        return properties;        
	    }

}
