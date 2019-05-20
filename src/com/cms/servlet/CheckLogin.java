package com.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.bean.User;
import com.cms.dao.UserDao;

/**
 * Servlet implementation class CheckLogin
 * ��½�ж�
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String users=request.getParameter("users");
		String pass=request.getParameter("pass");
		request.setCharacterEncoding("utf-8");//ǰ̨����ֵ
		response.setContentType("text/html;charset=utf-8");//���÷�����Ӧ����������͸�ʽ
		String keys = request.getParameter("keys");//��ȡǰ̨����������֤��
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String keysy = session.getAttribute("sess_captcha").toString();//��ȡ���ɵ���֤���ַ���
		UserDao s = new UserDao();
		User u = s.login(users, pass);
		if(u==null){
			out.println("<script>alert('��¼ʧ�ܣ�');location.href='login.jsp';</script>");
		}else if(keys.equalsIgnoreCase(keysy)){//�����ִ�Сд�Ƚ�
			Cookie cok = new Cookie("Qlcok",users);
			cok.setMaxAge(20);
			response.addCookie(cok);
			session.setAttribute("lname", users);//�Ự��������,�ڴ˱�����û���user
			response.sendRedirect("/GalaCMS/main.jsp");
		}else{
			out.println("<script>alert('��֤�����');location.href='login.jsp';</script>");
			
		}
	}

}
