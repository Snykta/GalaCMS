package com.cms.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cms.bean.NewsList;
import com.cms.dao.NewsDao;
import com.cms.util.Time;

/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String files = "";
    
  
    public AddNews() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id  = (int) (Math.floor(Math.random()*(99999-10000))+10000);//���id
		 Map<String, String> info = new HashMap<>();//������ͨ����
		String savePath =  "E:\\apache-tomcat-9.0.11\\webapps\\test";//����·��
		String message = "";
		File file  = new File(savePath);
		if(!file.exists()&&!file.isDirectory()) {//�ж��ϴ����ļ�·�������ڣ������ϴ����ǵ��ļ�
			file.mkdir();//�����ļ���
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();//��������
		ServletFileUpload upload = new ServletFileUpload(factory);//����������
		upload.setFileSizeMax(9000000);//�����ϴ����ݵĴ�С���ƣ���λ���ֽڣ�  
		upload.setHeaderEncoding("UTF-8");//��ֹ�ϴ����ļ�������
		if(!ServletFileUpload.isMultipartContent(request)) {//�ж���������ϴ�ͼƬ
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list) {
				if(item.isFormField()) {//�ж��Ƿ�λ��ͨ����ȡ�ļ�����ͨΪtrue�ļ�Ϊfalse
					info.put(item.getFieldName(), item.getString("utf-8"));//����ͨ�����ݴ���map����
				}else {
					String filename = item.getName();
					if(filename==null||filename.trim().equals("")) {
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream is = item.getInputStream();
					FileOutputStream fs = new FileOutputStream(savePath+"\\"+filename);
					System.out.println(savePath+"\\"+filename);
					files = filename;//����ͼ��ַ
					byte [] b = new byte[1024];
					int len =0;
					while((len=is.read(b))>0) {
						fs.write(b,0,len);
					}
					item.delete();
					message = "�ϴ��ɹ�";
				}
				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "�ϴ�ʧ��";	
		}
		
	System.out.println(message);
	NewsList nlists = new NewsList();
	nlists.setId(id);nlists.setTitle(info.get("titles"));nlists.setType(info.get("keys"));nlists.setKeyword(info.get("keys"));nlists.setCheck(Integer.parseInt(info.get("checks")));
	nlists.setReferaddress(info.get("yin"));nlists.setContent(info.get("nei"));nlists.setImage(files);nlists.setDate(Time.getTime());
	NewsDao nd = new NewsDao();
	int a = nd.addnEws(nlists);
	if(a>0) {
		response.getWriter().println("<script>alert('��ӳɹ���');location.href='newstable.jsp';</script>");
	}
		response.getWriter().println("<script>alert('���ʧ�ܣ�');location.href='addNews.jsp';</script>");
	}

}
