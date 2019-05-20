package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cms.bean.User;
import com.cms.util.Tool;

public class UserDao {
	private User u;
	
	public User login(String uname,String upwd) {//登陆判断
		Connection con = Tool.getcon();
		User u = null;
		PreparedStatement psmt = null;
		
		try {
			psmt = con.prepareStatement("select * from users where uuser = ? and upassword = ?");
			psmt.setString(1, uname);
			psmt.setString(2, upwd);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUname(rs.getString(1));
				u.setUuser(rs.getString(2));
				u.setUpassword(rs.getString(3));
				u.setSupers(rs.getInt(4));
				u.setEmil(rs.getString(5));
				u.setComment(rs.getString(6));
				u.setUtime(rs.getString(7));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			Tool.close(con, psmt);
		}
		return u;
	}
	
	public ResultSet selectUser(String user) {//判断是否已有相同账号存在
		Connection con = Tool.getcon();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("select * from users where uuser = ?");
			psmt.setString(1, user);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public String Userf(String zUser) {//查询昵称
		Connection con = Tool.getcon();
		PreparedStatement psmt = null;
		String lname = "";
		try {
			psmt = con.prepareStatement("select uname from users where uuser = ?");
			psmt.setString(1, zUser);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				lname = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Tool.close(con, psmt);
		}
		return lname;
		
		
	}
	
	public int addUser(String uname,String uuser,String upassword,int sup,String emil,String comment,String utime){//注册用户
		int a = 0;
		a = Tool.commonDATA("insert into users (uname,uuser,upassword,supers,emil,comment,utime)values(?,?,?,?,?,?,?)  ", new Object [] {uname,uuser,upassword,sup,emil,comment,utime});
		return a;
	}
	
	public List<User> getAllUsers(){//获取所有用户
		List userlist = new ArrayList();
		Connection con = Tool.getcon();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("select * from users");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUname(rs.getString(1));
				u.setUuser(rs.getString(2));
				u.setUpassword(rs.getString(3));
				u.setSupers(rs.getInt(4));
				u.setEmil(rs.getString(5));
				u.setComment(rs.getString(6));
				u.setUtime(rs.getString(7));
				userlist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Tool.close(con, pstm);
		}
		return userlist;
		
	}
	
	public int deleteUser(String uuser){//删除用户
		int a = 0;
		a = Tool.commonDATA("delete from users where uuser = ?", new Object [] {uuser});
		return a;
	}
	
	public int updataUser(User u){//修改用户
		int a = 0;
		a = Tool.commonDATA("update users set uname = ?,upassword = ?,supers = ?,emil = ?,comment =? where uuser = ?", new Object [] {u.getUname(),u.getUpassword(),u.getSupers(),u.getEmil(),u.getComment(),u.getUuser()});
		return a;
	}
	
	public User MesUser(String uuser){//查看用户信息
		Connection con = Tool.getcon();
		PreparedStatement psmt = null;
		User uu = new User();
		try {
			psmt = con.prepareStatement("select * from users where uuser = ?");
			psmt.setString(1, uuser);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				uu.setUname(rs.getString(1));
				uu.setUuser(rs.getString(2));
				uu.setUpassword(rs.getString(3));
				uu.setSupers(rs.getInt(4));
				uu.setEmil(rs.getString(5));
				uu.setComment(rs.getString(6));
				uu.setUtime(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Tool.close(con, psmt);
		}
		return uu;
	}
	
	public void addUsers(User user) {//添加用户
		Connection con = Tool.getcon();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("insert into users(uname,uuser,upassword,supers,emil,comment,utime) values (?,?,?,?,?,?,?)");
			psmt.setString(1, user.getUname());
			psmt.setString(2, user.getUuser());
			psmt.setString(3, user.getUpassword());
			psmt.setInt(4, user.getSupers());
			psmt.setString(5, user.getEmil());
			psmt.setString(6, user.getComment());
			psmt.setString(7, user.getUtime());
			int a = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Tool.close(con, psmt);
		}
		
	}
	

}

