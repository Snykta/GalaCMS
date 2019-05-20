package com.cms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter_1
 * 全局字符编码过滤器
 */
@WebFilter("/*")
public class Filter_1 implements Filter {

    public Filter_1() {
    }
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");前台传的值
		response.setContentType("text/html;charset=utf-8");设置返回响应后的数据类型格式
		System.out.println("************全局编码过滤器执行************");
		chain.doFilter(request, response);
	}

  
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
