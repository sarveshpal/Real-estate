package com.gw.RealEstate.Property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages= {"com.gw.RealEstate.Property","com.gw.RealEstate.Service","com.gw.RealEstate.DAO"})
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
       // System.out.println( "Hello World!" );
    }
}
