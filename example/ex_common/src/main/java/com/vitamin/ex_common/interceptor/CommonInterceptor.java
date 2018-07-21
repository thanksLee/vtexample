package com.vitamin.ex_common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class CommonInterceptor extends HandlerInterceptorAdapter {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
   
	@Override
	public boolean preHandle(  HttpServletRequest request
			                 , HttpServletResponse response
			                 , Object handler
			                 ) throws Exception {

		String _url = request.getRequestURI() == null ? "" : request.getRequestURI();
		Enumeration<String> paramNames = request.getParameterNames();
		
		logger.debug("########## 페이지 시작 ##########");
		logger.debug("Request URL : " + _url);
		
		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();
			String value = request.getParameter(key);
			logger.debug(" RequestParameter Data ==>  " + key + " : " + value + "");
		}
       
		return super.preHandle(request, response, handler);
	}
 
	@Override
	public void postHandle(	  HttpServletRequest request
							, HttpServletResponse response
							, Object handler
							, ModelAndView modelAndView
							) throws Exception {
		logger.debug("########## 페이지 종료 ##########");
	}
}
