package com.cms.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dowlond
 */
@WebServlet("/Dowlond")
public class Dowlond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dowlond() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");//获取jsp页面传过来的值，也就是指服务器中文件名字
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(name,"UTF-8"));
		//设置下载响应头，后面那一句话为转码，不然中文会乱码
		//String path = getServletContext().getRealPath("/file/"+name);//把虚拟服务器路径转为真实路径
		String path = "E:\\apache-tomcat-9.0.11\\webapps\\test\\"+name;
		
		System.out.println(path);
		FileInputStream fi = new FileInputStream(path);//输入流读取文件
		byte[] b = new byte[1024];
		int len =0;
		OutputStream fo = response.getOutputStream();//输出流写入文件，也就是下载，注意是get获取而不是直接new
		while((len=fi.read(b))>0) {
			fo.write(b,0,len);
		}
		fo.flush();
		fo.close();
		fi.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
