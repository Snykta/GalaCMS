   package com.cms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter_2
 * 全局登陆过滤器，如果没有登陆则无法访问main主页面
 */
@WebFilter("/*")
public class Filter_0 implements Filter {

    public Filter_0() {
        
    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;//类型转换，将ServletRequest转HttpServletRequest，是为了用其中的方法
		HttpSession session = httpRequest.getSession();//获取会话
		String url = httpRequest.getRequestURI();//获取url后半部分
		//System.out.println(url);
		if(url.endsWith(".png")||url.endsWith(".jpg")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith("login.jsp")||url.endsWith("register.jsp")||url.endsWith("CheckLogin")||url.endsWith("CheckRegister")||url.endsWith("Buffere")) {//筛选对哪些过滤
			chain.doFilter(request, response);//放行
		}else {
			if(session.getAttribute("lname")==null) {//因为登陆会创建会话，所以可以根据这个判断是否登陆
				System.out.println("************全局过滤到达了非法访问**********");
				httpResponse.sendRedirect("/GalaCMS/login.jsp");//如果非法访问则跳转到登陆页面
			}else {
				System.out.println("**********正常访问过滤通过********");
				chain.doFilter(request, response);
			}
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
