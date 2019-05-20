package com.cms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.bean.User;
import com.cms.dao.UserDao;
import com.cms.util.Time;
/**
 * ÃÌº””√ªß
 * @author snykt
 *
 */

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String user_u = request.getParameter("user_u");
		String user_pass = request.getParameter("user_pass");
		String emil = request.getParameter("user_emil");
		int superFlag = Integer.parseInt(request.getParameter("superFlag"));
		String comment = request.getParameter("comment");
		User user = new User();
		user.setUname(user_name);
		user.setUuser(user_u);
		user.setUpassword(user_pass);
		user.setEmil(emil);
		user.setSupers(superFlag);
		user.setComment(comment);
		user.setUtime(Time.getTime());
		UserDao ud = new UserDao();
		ud.addUsers(user);
		response.sendRedirect("/GalaCMS/userList.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("post");
	}

}
