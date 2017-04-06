package com.gotop.util.filter;

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

public class Struts2Update implements Filter {

     public  void doFilter(ServletRequest request, ServletResponse  response, FilterChain chain)
        throws IOException, ServletException {
    	 String contentType=request.getContentType();
    	 if(contentType!=null&&contentType.indexOf("ognl")!=-1){ 
    	 System.out.println(contentType);
    	 return;
    	 }else{  
    	 chain.doFilter(request, response);
    	 }
    	 
    	 
    }
    public void destroy() {
    }
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}	  
    
}