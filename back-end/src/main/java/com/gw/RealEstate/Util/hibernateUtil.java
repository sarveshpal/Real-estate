package com.gw.RealEstate.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
	
		public static final SessionFactory sf=buildSession();
		
		public static SessionFactory buildSession(){
			try{
				return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}catch(Throwable ex){
				System.err.println("Session factory creation failed"+ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static SessionFactory getSessionFactory(){
			return sf;
		}
	}
