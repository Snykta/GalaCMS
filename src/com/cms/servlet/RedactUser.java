package com.cms.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cms.bean.User;
import com.cms.dao.UserDao;
import com.cms.util.Tool;

/**
 * Servlet implementation class RedactUser
 * 信息编辑
 */
@WebServlet("/RedactUser")
public class RedactUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String user_u = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedactUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String u_name = request.getParameter("user_u");
		String pass = request.getParameter("user_pass");
		String emil = request.getParameter("user_emil");
		int sup = Integer.parseInt(request.getParameter("superFlag"));
		String com = request.getParameter("comment");
		User user = new User();
		user.setUuser(user_u);
		user.setUname(u_name);
		user.setUpassword(pass);
		user.setEmil(emil);
		user.setSupers(sup);
		user.setComment(com);
		UserDao ud = new UserDao();
		ud.updataUser(user);
		System.out.println(user_u);
		response.sendRedirect("/GalaCMS/userList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		 user_u = request.getParameter("username");
		Connection con = Tool.getcon();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("select * from users where uuser = ?");
			psmt.setString(1, user_u);
			ResultSet rs = psmt.executeQuery();
			String nuc =  convertJson(rs);
			response.getWriter().println(nuc);//返回出去
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static String convertJson(ResultSet rs) throws SQLException {//将读取数据库的数据转为数组的通用方法
//需要导入一个json包
		JSONArray json = new JSONArray();
		String value = "";
		ResultSetMetaData md = rs.getMetaData();// 获取键名
		int columnCount = md.getColumnCount();// 获取行的数量
		while (rs.next()) {
			JSONObject jo = new JSONObject();
			for (int i = 1; i <= columnCount; i++) {
				try {
					value = rs.getObject(i) + "";
					jo.put(md.getColumnName(i), value);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 获取键名及值
			}
			json.put(jo);
		}

		return json.toString();

	}

}
