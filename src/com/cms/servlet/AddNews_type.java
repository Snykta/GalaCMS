package com.cms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.bean.NewsType;
import com.cms.dao.NewsDao;

/**
 * Servlet implementation class AddNews_type
 */
@WebServlet("/AddNews_type")
public class AddNews_type extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddNews_type() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsType = request.getParameter("newstype_type");
		NewsType ntype = new NewsType();
		ntype.setNews_type(newsType);
		int a = NewsDao.addNews(ntype.getNews_type());
		if(a>0) {
			response.getWriter().println("<script>alert('添加成功！');location.href='newsTypeForm.jsp';</script>");
		}else {
			response.getWriter().println("<script>alert('添加失败！');location.href='newsTypeForm.jsp';</script>");
	}
	}

}
