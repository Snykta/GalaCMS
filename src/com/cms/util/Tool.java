package com.cms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Tool {
	private static String url;
	private static String urlname;
	private static String driver;
	private static String password;
	
	static {
		Properties pp = null;
		InputStream in = null;
		pp = new Properties();
		in = Tool.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		try {
			pp.load(in);
			url = pp.getProperty("url");
			urlname = pp.getProperty("username");
			driver = pp.getProperty("driver");
			password = pp.getProperty("password");
		} catch (Exception e) {
			System.out.println("加载信息失败"+e);
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in = null;
		}
		
	}
	
	public static Connection getcon(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,urlname,password);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败"+e);
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void close(Connection con,PreparedStatement pstm) {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static int commonDATA(String sql,Object[] obj) {
		Connection con = getcon();//获取数据库连接
		PreparedStatement psmt = null;
		int a = 0;
		try {
			psmt = con.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				psmt.setObject(i+1, obj[i]); //设置SQL语句的占位符
			}
			a = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,psmt);
		}
		return a;
	}

}

