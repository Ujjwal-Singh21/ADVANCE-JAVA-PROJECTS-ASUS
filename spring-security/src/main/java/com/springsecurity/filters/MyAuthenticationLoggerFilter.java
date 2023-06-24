package com.springsecurity.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class MyAuthenticationLoggerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		 HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		 
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		 if(authentication != null) {
			 System.out.println("username: " + authentication.getName() + " Authorities " + authentication.getAuthorities());
		 }
		 chain.doFilter(httpServletRequest, httpServletResponse);
	}

}
