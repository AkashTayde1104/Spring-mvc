package com.tech.utility;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.tech")
public class AppConfig
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver r=new InternalResourceViewResolver();
		r.setSuffix(".jsp");
		return r;
		
	}
	
	@Bean
	public DriverManagerDataSource driverManager()
	{
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/bank_mvc");
		dm.setUsername("root");
		dm.setPassword("root");
		return dm;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sf()
	{
		LocalSessionFactoryBean sf1=new LocalSessionFactoryBean();
		sf1.setDataSource(driverManager());
		Properties p=new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		sf1.setHibernateProperties(p);
		sf1.setAnnotatedClasses(com.tech.model.Account.class);
	
	
	
		return sf1;
	}

}
