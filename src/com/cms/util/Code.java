package com.cms.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Code {
	
	public static void codes(String str1,String str2) {
// 收件人电子邮箱
        String to = str1;
// 发件人电子邮箱
        String from = "邮箱";
// 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com"; //QQ 邮件服务器
// 获取系统属性
        Properties properties = System.getProperties();
// 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
// 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("邮箱", "授权码"); //发件人邮件用户名、授权码
            }
        });
        try{
// 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
// Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
// Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
// Set Subject: 头部头字段
            message.setSubject("学生管理系统注册验证码");
// 设置消息体
            message.setText("您的注册验证码为："+str2+"\r\n\r\n如果不是您本人操作请忽略。");
// 发送消息
            Transport.send(message);
            System.out.println("发送成功");
        }catch (Exception mex) {
            mex.printStackTrace();
            System.out.println("发送失败"+mex);
        }
    }
		
}
