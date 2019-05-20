package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cms.bean.NewsList;
import com.cms.bean.NewsType;
import com.cms.util.Tool;

public class NewsDao {
	private NewsType nt;
	private NewsList nlists;
	
	public static int addNews(String news_type) {//添加新闻类别
		int a = 0;
		a = Tool.commonDATA("insert into newstype (newstype_type) values (?)", new Object [] {news_type});
		return a;
	}
	
	public List<NewsType> newsList() {//查询所有新闻类型
		Connection conn = Tool.getcon();
		List<NewsType> lists = new ArrayList<>();
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement("select * from newstype");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				nt = new NewsType();
				nt.setNews_id(rs.getInt(1));
				nt.setNews_type(rs.getString(2));
				nt.setNews_date(rs.getString(3));
				lists.add(nt);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
		
	}
	
	
	public List<NewsList> Newslist(){//查询所有新闻列表
		Connection conn = Tool.getcon();
		List<NewsList> newslists = new ArrayList<>();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement("select * from news");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				nlists = new NewsList();
				nlists.setId(rs.getInt(1));
				nlists.setTitle(rs.getString(2));
				nlists.setType(rs.getString(3));
				nlists.setKeyword(rs.getString(4));
				nlists.setCheck(rs.getInt(5));
				nlists.setReferaddress(rs.getString(6));
				nlists.setContent(rs.getString(7));
				nlists.setImage(rs.getString(8));
				nlists.setDate(rs.getString(9));
				newslists.add(nlists);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newslists;
		
	}
	
	public static int addnEws(NewsList nlists) {//添加新闻
		int a = 0;
		a = Tool.commonDATA("insert into news (news_id,new_title,new_type,news_keyword,news_check,news_referaddress,news_content,news_image,news_date) values (?,?,?,?,?,?,?,?,?)", 
				new Object [] {nlists.getId(),nlists.getTitle(),nlists.getType(),nlists.getKeyword(),nlists.getCheck(),nlists.getReferaddress(),nlists.getContent(),nlists.getImage(),nlists.getDate()});
		return a;
	}
	
	public static int deleteNews(String id) {//删除新闻
		int a = 0;
		a = Tool.commonDATA("delete from news where news_id = ?", new Object [] {id});
		return a;
	}

}
