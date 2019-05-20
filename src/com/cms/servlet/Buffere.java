package com.cms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.util.Cores;

/**
 * Servlet implementation class Buffere
 * ��֤��
 */
@WebServlet("/Buffere")
public class Buffere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Buffere() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");// ������Ӧ����,������������������ΪͼƬ
        response.setHeader("Pragma", "No-cache");// ������Ӧͷ��Ϣ�������������Ҫ���������
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        Cores randomValidateCode = new Cores();
        try {
            randomValidateCode.getRandcode(request, response);// ���ͼƬ����
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
