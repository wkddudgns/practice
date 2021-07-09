package com.one.two.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;


import javax.mail.Session;

@Component
public class EmailConfirm{
	
	String[] random = new String[1];

	
		public String random1(String authNum) {
		random[0] = authNum;
		return random[0];
		}

		public String random2() {
			return random[0];
		}
	
	public String connectEmail(String email){
	

		String to1=email; // 인증위해 사용자가 입력한 이메일주소
		String host="smtp.gmail.com"; // smtp 서버
		String subject="인증번호 전달"; // 보내는 제목 설정
		String fromName="관리자"; // 보내는 이름 설정
		String from="pinevol7@gmail.com"; // 보내는 사람(구글계정)
		String authNum=EmailConfirm.authNum(); // 인증번호 위한 난수 발생부분
		String content="<!doctype html> " + "<html lang='ko'> " + " <head>" + "<title>이메일 인증</title>"
				+ "<meta charset=\"utf-8\">\n"
				+ "\n"
				+ "				  </head>\n" + "				  <body>\n"
				+ "				    <div class=\"jumbotron jumbotron-fluid\">\n"
				+ "				  <div align=\"center\" class=\"container\">\n"
				+ "				    <h1 class=\"display-3\">이메일 인증</h1><br>\n"
				+ "				    <p class=\"lead\">안녕하세요. <font size=\"5\" color=\"red\"><b>아이엠그루트</b></font> 입니다.\n"
				+ "				        <br>\n" + "				        인증번호는 다음과 같습니다.<br><font size=\"7\"> [ "
				+ authNum +
				" ] </font>\n" + "				      </p>\n"
				+ "				         <p class=\"lead\">\n"
				+ "				  </p>\n" + "				  </div>\n" + "				</div>\n" + "\n"
				+ "				  </body>\n" + "				</html>"; // 이메일 내용 설정
		random1(authNum);
		
		
		// SMTP 이용하기 위해 설정해주는 설정값들
		try{
		Properties props=new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.setProperty
                       ("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port","465");
		props.put("mail.smtp.user",from);
		props.put("mail.smtp.auth","true");
		
		Session mailSession 
           = Session.getInstance(props,new javax.mail.Authenticator(){
			    protected PasswordAuthentication getPasswordAuthentication(){
				    return new PasswordAuthentication
                                        ("pinevol7@gmail.com","wnsgud07"); // gmail계정
			}
			    
		});
		
		Message msg = new MimeMessage(mailSession);
		InternetAddress []address1 = {new InternetAddress(to1)};
		msg.setFrom(new InternetAddress
                      (from, MimeUtility.encodeText(fromName,"utf-8","B")));
		msg.setRecipients(Message.RecipientType.TO, address1); // 받는사람 설정
		msg.setSubject(subject); // 제목설정
		msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
		msg.setContent(content,"text/html; charset=utf-8"); // 내용설정
		
		Transport.send(msg); // 메일보내기
		}catch(MessagingException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return authNum;
	}

    // 난수발생 function
	public static String authNum(){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<=4;i++){
			int num=(int)(Math.random()*9+1);
			buffer.append(num);
		}
		return buffer.toString();
	}
}
