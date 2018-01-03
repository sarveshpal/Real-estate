package com.gw.RealEstate.SMS;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SendSms{

	
public static String send(long d)
{
	OTP otp= new OTP();
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		 protected PasswordAuthentication getPasswordAuthentication() {  
			   return new PasswordAuthentication("jitkuk","b1bf5eaf89XX");  }  
	});
	String otpvalue=otp.OTP(4);
//Your user name
String username = "jitkuk";
//Your authentication key
String authkey = "b1bf5eaf89XX";
//Multiple mobiles numbers separated by comma (max 200)
long mobiles =(long) d;
//Sender ID,While using route4 sender id should be 6 characters long.
String senderId = "CLNIND";
//Your message to send, Add URL encoding here.
String message = "YOUR OTP IS :"+otpvalue ;
//define route
String accusage="1";

//Prepare Url
URLConnection myURLConnection=null;
URL myURL=null;
BufferedReader reader=null;

//encoding message
@SuppressWarnings("deprecation")
String encoded_message=URLEncoder.encode(message);

//Send SMS API
String mainUrl="http://sms.bulkssms.com/submitsms.jsp?";

//Prepare parameter string
StringBuilder sbPostData= new StringBuilder(mainUrl);
sbPostData.append("user="+username);
sbPostData.append("&key="+authkey);
sbPostData.append("&mobile="+mobiles);
sbPostData.append("&message="+encoded_message);
sbPostData.append("&accusage="+accusage);
sbPostData.append("&senderid="+senderId);

//final string
mainUrl = sbPostData.toString();
try
{
//prepare connection
myURL = new URL(mainUrl);
myURLConnection = myURL.openConnection();
myURLConnection.connect();
reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
//reading response
String response;
while ((response = reader.readLine()) != null)
//print response
System.out.println(response);
System.out.println("OTP IS :"+message);
//finally close connection
reader.close();
}
catch (IOException e)
{
e.printStackTrace();
}
return otpvalue;
}



}