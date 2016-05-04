package com.jsg.base.freemarker;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.jsg.base.util.SpringBeanLocator;
/**
 * 
* @ClassName: FreemarkerFilter 
* @Description: TODO(处理freemarker) 
* @author duanws
* @date 2016-4-21 下午5:04:36 
*
 */
public class FreemarkerFilter implements Filter{
	
	private Locale locale;
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try{
			String name = req.getServletPath();
			name = name.substring(1, name.lastIndexOf(".ftl"));
			
			FreeMarkerViewResolver viewResolver = (FreeMarkerViewResolver) SpringBeanLocator.getBean("viewResolver");
			View view = viewResolver.resolveViewName(name, locale);
			view.render(null, req, res);
		}catch(Exception ex){
			throw new ServletException(ex);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String localeStr = filterConfig.getInitParameter("locale");
		if(StringUtils.hasText(localeStr)){
			this.locale = new Locale(localeStr);
		}else{
			this.locale = Locale.getDefault();
		}
	}

	
}
