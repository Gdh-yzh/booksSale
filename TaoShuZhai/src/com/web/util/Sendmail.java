package com.web.util;

import java.security.Security;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.net.ssl.internal.ssl.Provider;

public class Sendmail {
	private String from = "12246187976@qq.com";
	private String User = "1224618976";
	String password = "sdadasdasd";
	
	public Sendmail(){
		
	}
	
	public void sendMail(String to,String text,String title){
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.auth", "true");
		
		//安全认证
		Security.addProvider(new Provider());
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		try{
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);
			Multipart multipart = new MimeMultipart();
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(text,"text/html;charset=utf-8");
			multipart.addBodyPart(contentPart);
			message.setContent(multipart);
			message.saveChanges();
			Transport transport = session.getTransport("smtp"); 
			transport.connect("smtp.qq.com",User,password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
	
	public String sendRegistMail(String to,String userName){
		String registerId = "" + Math.random() * Math.random();
		String url = "";
		String text = "";
		String title = "";
		sendMail(to,text,title);
		return registerId;
	}
}
