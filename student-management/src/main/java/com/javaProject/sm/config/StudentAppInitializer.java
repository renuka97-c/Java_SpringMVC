package com.javaProject.sm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		
		Class[] configFiles = {StudentAppConfig.class}; 
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//to handle every url
		String[] mappings = {"/"};
		return mappings;
	}

}
