package com.jsg.base.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

public class LoginFilter implements HandlerInterceptor{
	  private List<String> excludedUrls;
	  private PathMatcher pathMatcher = new AntPathMatcher();

	  public void setExcludedUrls(List<String> excludedUrls)
	  {
	    this.excludedUrls = excludedUrls;
	  }
	//该方法将在请求处理之前进行调用
	@Override  
	public boolean preHandle(HttpServletRequest request,  
	        HttpServletResponse response, Object handler) throws Exception {  
	    String requestUri = request.getRequestURI();
	    HttpSession session = request.getSession();
	    
	    String urlPath = request.getContextPath();
	    session.setAttribute("urlPath", urlPath);
	    session.setAttribute("session", session);
	    //操作左侧菜单列表
		String menuPid = request.getParameter("menuPid");
		String menuId = request.getParameter("menuId");
		session.setAttribute("menuPid", menuPid);
		session.setAttribute("menuId", menuId);
		
	    for (String url : this.excludedUrls) {
	      if (pathsMatch(url, request)) {
	        return true;
	      }

	    }

	    if (session.getAttribute("user_key") == null) {
	    response.sendRedirect(request.getContextPath() + "/login.do");
	    return false;  
	    }
	    return true;
	}  
	  
	@Override  
	public void postHandle(HttpServletRequest request,  
	        HttpServletResponse response, Object handler,  
	        ModelAndView modelAndView) throws Exception {  
	}  
	  
	@Override  
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			    throws Exception
			  {
			  }
	  protected boolean pathsMatch(String path, ServletRequest request)
	  {
	    String requestURI = getPathWithinApplication(request);

	    return pathsMatch(path, requestURI);
	  }

	  protected boolean pathsMatch(String pattern, String path) {
	    return this.pathMatcher.match(pattern, path);
	  }

	  protected String getPathWithinApplication(ServletRequest request) {
	    return WebUtil.getPathWithinApplication((HttpServletRequest)request);
	  }
}
