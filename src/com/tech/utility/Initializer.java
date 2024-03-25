package com.tech.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
	AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
	ac.register(AppConfig.class);
	ac.setServletContext(sc);
	ServletRegistration.Dynamic sdy=sc.addServlet("DispatcherServlet", new DispatcherServlet(ac));
    sdy.addMapping("/");
  
   
		
	}
	
	
	

}
