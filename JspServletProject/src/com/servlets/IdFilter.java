package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/addAlien")
public class IdFilter extends HttpFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request; // tycated ServletRequest to HttpServletRequest
		int aliendId = Integer.parseInt(req.getParameter("aid"));

		if (aliendId > 1) 
			// pass the request along the filter chain
			chain.doFilter(req, response);
		 else 
			out.print("Aliend Id shoud be greater than one");
	}

	@Override
	public void destroy() {
	}

}
