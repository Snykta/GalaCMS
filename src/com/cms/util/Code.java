package com.cms.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Code {
	
	public static void codes(String str1,String str2) {
// �ռ��˵�������
        String to = str1;
// �����˵�������
        String from = "����";
// ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com"; //QQ �ʼ�������
// ��ȡϵͳ����
        Properties properties = System.getProperties();
// �����ʼ�������
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
// ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("����", "��Ȩ��"); //�������ʼ��û�������Ȩ��
            }
        });
        try{
// ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);
// Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));
// Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
// Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("ѧ������ϵͳע����֤��");
// ������Ϣ��
            message.setText("����ע����֤��Ϊ��"+str2+"\r\n\r\n������������˲�������ԡ�");
// ������Ϣ
            Transport.send(message);
            System.out.println("���ͳɹ�");
        }catch (Exception mex) {
            mex.printStackTrace();
            System.out.println("����ʧ��"+mex);
        }
    }
		
}
