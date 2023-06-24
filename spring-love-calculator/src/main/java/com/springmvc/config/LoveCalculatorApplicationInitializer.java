package com.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer // implements WebApplicationInitializer 
{

//	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
//		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:beans.xml");
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		// create our Dispatcher Servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		// Register it with ServletContext
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
	}

}
