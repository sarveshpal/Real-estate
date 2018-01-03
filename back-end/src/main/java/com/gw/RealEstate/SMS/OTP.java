package com.gw.RealEstate.SMS;
import java.util.Random;

public class OTP{
	
	public static String OTP(int len)
    {
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");
 
        // Using numeric values
        String numbers = "0123456789";
 
        // Using random method
        Random rndm_method = new Random();
        String msg="";
        char[] otp = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
             numbers.charAt(rndm_method.nextInt(numbers.length()));
         msg=msg+otp[i];   
        }
        
        return msg;
    }
//   public static void main(String[] args)
//    {
//        int length = 4;
//        System.out.println(OTP(length));
//    }
}
