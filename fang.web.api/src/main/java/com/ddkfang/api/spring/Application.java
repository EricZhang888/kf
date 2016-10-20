package com.ddkfang.api.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ddkfang.dao.spring.DaoContextConfiguration;

public class Application implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext apiContext = new AnnotationConfigWebApplicationContext();
		apiContext.register(RestServletContextConfiguration.class);
		
		container.addListener(new ContextLoaderListener(apiContext));
		container.getServletRegistration("default").addMapping("*.html","/fangdong/*","*.txt","/css/*", "/js/*", "/img/*");
		ServletRegistration.Dynamic dispatcher = container.addServlet("api",new DispatcherServlet(apiContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		AnnotationConfigWebApplicationContext daoContext = new AnnotationConfigWebApplicationContext();
		daoContext.setParent(apiContext);
		daoContext.register(DaoContextConfiguration.class);
//		DispatcherServlet daoServlet = new DispatcherServlet(daoContext);
//		dispatcher = container.addServlet("dao", daoServlet);
//		dispatcher.setLoadOnStartup(2);
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}
	
}
