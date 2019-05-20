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
 * 登陆判断
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
		request.setCharacterEncoding("utf-8");//前台传的值
		response.setContentType("text/html;charset=utf-8");//设置返回响应后的数据类型格式
		String keys = request.getParameter("keys");//获取前台传过来的验证码
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String keysy = session.getAttribute("sess_captcha").toString();//获取生成的验证码字符串
		UserDao s = new UserDao();
		User u = s.login(users, pass);
		if(u==null){
			out.println("<script>alert('登录失败！');location.href='login.jsp';</script>");
		}else if(keys.equalsIgnoreCase(keysy)){//不区分大小写比较
			Cookie cok = new Cookie("Qlcok",users);
			cok.setMaxAge(20);
			response.addCookie(cok);
			session.setAttribute("lname", users);//会话保存数据,在此保存的用户名user
			response.sendRedirect("/GalaCMS/main.jsp");
		}else{
			out.println("<script>alert('验证码错误！');location.href='login.jsp';</script>");
			
		}
	}

}
