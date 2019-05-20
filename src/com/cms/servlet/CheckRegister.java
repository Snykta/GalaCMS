package com.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cms.dao.UserDao;
import com.cms.util.Code;
import com.cms.util.Time;

/**
 * Servlet implementation class CheckRegister
 * 注册判断
 */
@WebServlet("/CheckRegister")
public class CheckRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String str;
    public CheckRegister() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//前台传的值
		response.setContentType("text/html;charset=utf-8");//设置返回响应后的数据类型格式
		String emil = request.getParameter("youxiang").toString();
		int a  = (int) (Math.floor(Math.random()*(9999-1000))+1000);//随机数
		str = Integer.toString(a);//转为字符串
		Code.codes(emil, str);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nickname = request.getParameter("Username");//姓名
		String userk = request.getParameter("User1");//账号
		String passwo = request.getParameter("Password");//密码
		String emils = request.getParameter("emils");//邮箱
		String keys = request.getParameter("keys");//验证码
		PrintWriter out = response.getWriter();
		UserDao u = new UserDao();
		ResultSet rs = u.selectUser(userk);
		try {
			if(rs.next()){
				out.println("<script>alert('该用户已存在，请重新注册！');location.href='register.jsp';</script>");
			}else{
				if(keys.equals(str)) { 
					int a = u.addUser(nickname, userk, passwo,1,emils,"无备注!", Time.getTime());
					if(a!=0){
						out.println("<script>alert('注册成功！');location.href='login.jsp';</script>");
					}else{
						out.println("<script>alert('注册失败！');location.href='register.jsp';</script>");
					}
				}else {
					out.println("<script>alert('验证码错误！');location.href='register.jsp';</script>");
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
