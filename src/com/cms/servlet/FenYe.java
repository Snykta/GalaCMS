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

import com.cms.util.Tool;

/**
 * Servlet implementation class FenYe
 */
@WebServlet("/FenYe")
public class FenYe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FenYe() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("num1"));//�ӵڼ���
		Connection con = Tool.getcon();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("select * from news limit ?,3");
			psmt.setInt(1, n);
			ResultSet rs = psmt.executeQuery();
			String nuc =  convertJson(rs);
			response.getWriter().println(nuc);//���س�ȥ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static String convertJson(ResultSet rs) throws SQLException {//����ȡ���ݿ������תΪ�����ͨ�÷���
		//��Ҫ����һ��json��
				JSONArray json = new JSONArray();
				String value = "";
				ResultSetMetaData md = rs.getMetaData();// ��ȡ����
				int columnCount = md.getColumnCount();// ��ȡ�е�����
				while (rs.next()) {
					JSONObject jo = new JSONObject();
					for (int i = 1; i <= columnCount; i++) {
						try {
							value = rs.getObject(i) + "";
							jo.put(md.getColumnName(i), value);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}// ��ȡ������ֵ
					}
					json.put(jo);
				}

				return json.toString();

			}

}
