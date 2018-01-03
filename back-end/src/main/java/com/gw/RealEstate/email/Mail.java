package com.gw.RealEstate.email;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gw.RealEstate.SMS.OTP;

import javax.mail.internet.*; 
public class Mail {


	public static String send(String to){
		
	  Properties props = new Properties();  
	  props.put("mail.smtp.host", "smtp.gmail.com");  
	  props.put("mail.smtp.socketFactory.port", "465");  
	  props.put("mail.smtp.socketFactory.class",  
	            "javax.net.ssl.SSLSocketFactory");  
	  props.put("mail.smtp.auth", "true");  
	  props.put("mail.smtp.port", "465"); 
	  
	  OTP otp = new OTP();
	   
	   Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {  
	   protected PasswordAuthentication getPasswordAuthentication() {  
	   return new PasswordAuthentication("greatwitsservices@gmail.com","Greatminds");  }  
	  
	   }); 
	   
	  try {  
		 String otpvalue=otp.OTP(4);
	   MimeMessage message = new MimeMessage(session);  
	   message.setFrom(new InternetAddress("greatwitsservices@gmail.com"));
	   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	   message.setSubject("Welcome to Ghar Dekho");  

	    BodyPart messageBodyPart1 = new MimeBodyPart();  
	    messageBodyPart1.setContent("<h3>Dear Customer,</h3>","text/html");
		
	    BodyPart messageBodyPart2 = new MimeBodyPart();  
	    messageBodyPart2.setText("Your password is: "+otpvalue);

	    BodyPart messageBodyPart3 = new MimeBodyPart();  
	    messageBodyPart3.setContent("<p style='padding-bottom:5px;'>Sincerely,<br>Greatwits Services</p><div style='border-top:1px solid gray; padding:5px 30px;'><span style='float:left;'><small>The message was sent from an unmonitored email address.<br>Please do not reply to this message</small></span><span  style='float:right; color:maroon;'><strong>UNIVERSAL TEAM</strong></span></div>","text/html");

	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart1);  
	    multipart.addBodyPart(messageBodyPart2);  
	    multipart.addBodyPart(messageBodyPart3);
	 
	    message.setContent(multipart);   
	   Transport.send(message);  
	  
	   System.out.println("----------------------message sent successfully");  
	   return otpvalue;
	  }
	  catch (MessagingException e){
	      throw new RuntimeException(e);
	  } 
	  
	 }
}
