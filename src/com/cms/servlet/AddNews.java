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
		int id  = (int) (Math.floor(Math.random()*(99999-10000))+10000);//随机id
		 Map<String, String> info = new HashMap<>();//保存普通属性
		String savePath =  "E:\\apache-tomcat-9.0.11\\webapps\\test";//保存路径
		String message = "";
		File file  = new File(savePath);
		if(!file.exists()&&!file.isDirectory()) {//判断上传的文件路径不存在，并且上传的是单文件
			file.mkdir();//创建文件夹
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();//创建工厂
		ServletFileUpload upload = new ServletFileUpload(factory);//创建解析器
		upload.setFileSizeMax(9000000);//设置上传内容的大小限制（单位：字节）  
		upload.setHeaderEncoding("UTF-8");//防止上传的文件名乱码
		if(!ServletFileUpload.isMultipartContent(request)) {//判断如果不带上传图片
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list) {
				if(item.isFormField()) {//判断是否位普通表单获取文件，普通为true文件为false
					info.put(item.getFieldName(), item.getString("utf-8"));//将普通表单数据存入map里面
				}else {
					String filename = item.getName();
					if(filename==null||filename.trim().equals("")) {
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream is = item.getInputStream();
					FileOutputStream fs = new FileOutputStream(savePath+"\\"+filename);
					System.out.println(savePath+"\\"+filename);
					files = filename;//缩略图地址
					byte [] b = new byte[1024];
					int len =0;
					while((len=is.read(b))>0) {
						fs.write(b,0,len);
					}
					item.delete();
					message = "上传成功";
				}
				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "上传失败";	
		}
		
	System.out.println(message);
	NewsList nlists = new NewsList();
	nlists.setId(id);nlists.setTitle(info.get("titles"));nlists.setType(info.get("keys"));nlists.setKeyword(info.get("keys"));nlists.setCheck(Integer.parseInt(info.get("checks")));
	nlists.setReferaddress(info.get("yin"));nlists.setContent(info.get("nei"));nlists.setImage(files);nlists.setDate(Time.getTime());
	NewsDao nd = new NewsDao();
	int a = nd.addnEws(nlists);
	if(a>0) {
		response.getWriter().println("<script>alert('添加成功！');location.href='newstable.jsp';</script>");
	}
		response.getWriter().println("<script>alert('添加失败！');location.href='addNews.jsp';</script>");
	}

}
