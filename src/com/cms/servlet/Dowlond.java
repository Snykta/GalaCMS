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
		String name = request.getParameter("name");//��ȡjspҳ�洫������ֵ��Ҳ����ָ���������ļ�����
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(name,"UTF-8"));
		//����������Ӧͷ��������һ�仰Ϊת�룬��Ȼ���Ļ�����
		//String path = getServletContext().getRealPath("/file/"+name);//�����������·��תΪ��ʵ·��
		String path = "E:\\apache-tomcat-9.0.11\\webapps\\test\\"+name;
		
		System.out.println(path);
		FileInputStream fi = new FileInputStream(path);//��������ȡ�ļ�
		byte[] b = new byte[1024];
		int len =0;
		OutputStream fo = response.getOutputStream();//�����д���ļ���Ҳ�������أ�ע����get��ȡ������ֱ��new
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
