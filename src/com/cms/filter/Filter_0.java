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
 * ȫ�ֵ�½�����������û�е�½���޷�����main��ҳ��
 */
@WebFilter("/*")
public class Filter_0 implements Filter {

    public Filter_0() {
        
    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;//����ת������ServletRequestתHttpServletRequest����Ϊ�������еķ���
		HttpSession session = httpRequest.getSession();//��ȡ�Ự
		String url = httpRequest.getRequestURI();//��ȡurl��벿��
		//System.out.println(url);
		if(url.endsWith(".png")||url.endsWith(".jpg")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith("login.jsp")||url.endsWith("register.jsp")||url.endsWith("CheckLogin")||url.endsWith("CheckRegister")||url.endsWith("Buffere")) {//ɸѡ����Щ����
			chain.doFilter(request, response);//����
		}else {
			if(session.getAttribute("lname")==null) {//��Ϊ��½�ᴴ���Ự�����Կ��Ը�������ж��Ƿ��½
				System.out.println("************ȫ�ֹ��˵����˷Ƿ�����**********");
				httpResponse.sendRedirect("/GalaCMS/login.jsp");//����Ƿ���������ת����½ҳ��
			}else {
				System.out.println("**********�������ʹ���ͨ��********");
				chain.doFilter(request, response);
			}
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
