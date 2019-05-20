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
 * ע���ж�
 */
@WebServlet("/CheckRegister")
public class CheckRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String str;
    public CheckRegister() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//ǰ̨����ֵ
		response.setContentType("text/html;charset=utf-8");//���÷�����Ӧ����������͸�ʽ
		String emil = request.getParameter("youxiang").toString();
		int a  = (int) (Math.floor(Math.random()*(9999-1000))+1000);//�����
		str = Integer.toString(a);//תΪ�ַ���
		Code.codes(emil, str);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nickname = request.getParameter("Username");//����
		String userk = request.getParameter("User1");//�˺�
		String passwo = request.getParameter("Password");//����
		String emils = request.getParameter("emils");//����
		String keys = request.getParameter("keys");//��֤��
		PrintWriter out = response.getWriter();
		UserDao u = new UserDao();
		ResultSet rs = u.selectUser(userk);
		try {
			if(rs.next()){
				out.println("<script>alert('���û��Ѵ��ڣ�������ע�ᣡ');location.href='register.jsp';</script>");
			}else{
				if(keys.equals(str)) { 
					int a = u.addUser(nickname, userk, passwo,1,emils,"�ޱ�ע!", Time.getTime());
					if(a!=0){
						out.println("<script>alert('ע��ɹ���');location.href='login.jsp';</script>");
					}else{
						out.println("<script>alert('ע��ʧ�ܣ�');location.href='register.jsp';</script>");
					}
				}else {
					out.println("<script>alert('��֤�����');location.href='register.jsp';</script>");
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
