package com.jsg.base.filter;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.ServletContextAware;


public class SpringBeanLocator implements BeanFactoryAware,ServletContextAware{
	private static Logger logger = (Logger) LoggerFactory.getLogger(SpringBeanLocator.class);
	
	private static BeanFactory beanFactory = null;
	
	private static ServletContext servletContext = null;
	
	@Override
	public void setServletContext(ServletContext servletContext){
		servletContext = servletContext;
	}

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		beanFactory = factory;
		
	}
	
	public BeanFactory getBeanFactory(){
		return beanFactory;
	}
	
	public static Object getBean(String servName){
		Object o = null;
		try{
			o = beanFactory.getBean(servName);
		}catch(NoSuchBeanDefinitionException ex){
			logger.warn(ex.toString());
		}
		return o;
	}
	
	public static Object getBean(String servName, Class<?> clazz){
		return beanFactory.getBean(servName,clazz);
	}
	public static ServletContext getServletContext(){
		return servletContext;
	}

}
