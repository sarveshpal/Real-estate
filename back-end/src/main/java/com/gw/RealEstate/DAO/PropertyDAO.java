package com.gw.RealEstate.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.gw.RealEstate.Entity.PersonalDetails;
import com.gw.RealEstate.Entity.PropertyDetails;
import com.gw.RealEstate.Util.hibernateUtil;

@Repository
public class PropertyDAO {

	public List<PersonalDetails> getdetail() {
		// TODO Auto-generated method stub
		Session sess=hibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		List<PersonalDetails> data=sess.createQuery("FROM PersonalDetails").list();
		sess.getTransaction().commit();
		sess.close();
		return data;
	}

	
	public void post(PersonalDetails pd) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails pd1=new PersonalDetails();
		pd1.setFullname(pd.getFullname());
		pd1.setUsername(pd.getUsername());
		pd1.setEmail(pd.getEmail());
		pd1.setPassword(pd.getPassword());
		pd1.setPhone(pd.getPhone());
		pd1.setStat(pd.getStat());
		session.save(pd1);
		System.out.println("add personal detail successfully");
		session.getTransaction().commit();
		session.close();
	}

	public void update(int id, PersonalDetails personaldetail) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
	      System.out.println("Update Successfully");
	      session.save(personaldetail);
	 
	      session.close();     
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails pd=(PersonalDetails) session.load(PersonalDetails.class, id);
		session.delete(pd);
		System.out.println("Delete Successfully");
		session.getTransaction().commit();
		session.close();
	}


	public List<PropertyDetails> getdetail1() {
		// TODO Auto-generated method stub
		Session sess=hibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		List<PropertyDetails> data=sess.createQuery("FROM PropertyDetails").list();
		sess.getTransaction().commit();
		sess.close();
		return data;
	}
	
	public void post1(PropertyDetails pd1,int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails pd=(PersonalDetails)session.get(PersonalDetails.class, id);
		List<PersonalDetails> listpd=session.createQuery("FROM PersonalDetails").list();
		for(int i=0;i<listpd.size();i++){
			PersonalDetails prop=listpd.get(i);
			if(prop==pd){
				pd1.setPd(pd);
			}
		}
		session.save(pd1);
		System.out.println("add property detail successfully");
		session.getTransaction().commit();
		session.close();
	}


	public void update1(int id, PropertyDetails pd1) {
		// TODO Auto-generated method stub
		if(pd1!=null){
		Session session=hibernateUtil.getSessionFactory().openSession();
		//System.out.println(pd1);
		Transaction transaction=null;
		try{ 
		transaction=session.beginTransaction();
		PropertyDetails propertydetail=session.get(PropertyDetails.class,id);
		List<PropertyDetails> listpd=session.createQuery("FROM PropertyDetails").list();
		for(int i=0;i<listpd.size();i++){
			PropertyDetails detail=listpd.get(i);
			if(detail.getPropId()==propertydetail.getPropId()){
				propertydetail.setTitle(pd1.getTitle());
				propertydetail.setPropStatus(pd1.getPropStatus());
				propertydetail.setType(pd1.getType());
				propertydetail.setPrice(pd1.getPrice());
				propertydetail.setArea(pd1.getArea());
				propertydetail.setSuperarea(pd1.getSuperarea());
				propertydetail.setCarpetarea(pd1.getCarpetarea());
				propertydetail.setLocation(pd1.getLocation());
			//	propertydetail.setPostalcode(pd1.getPostalcode());
				propertydetail.setInfo(pd1.getInfo());
				propertydetail.setName(pd1.getName());
				propertydetail.setEmail(pd1.getEmail());
				propertydetail.setPhone(pd1.getPhone());
			}
		}
				session.update(propertydetail);
				transaction.commit();
	      System.out.println("Update property Successfully");
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		}
		else{
			System.out.println("object is null");
		}
	}


	public void delete1(int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		//System.out.println(pd1);
		Transaction transaction=null;
		try{ 
		transaction=session.beginTransaction();
		PropertyDetails propertydetail=session.get(PropertyDetails.class,id);
		List<PropertyDetails> listpd=session.createQuery("FROM PropertyDetails").list();
		for(int i=0;i<listpd.size();i++){
			PropertyDetails detail=listpd.get(i);
			if(detail.getPropId()==propertydetail.getPropId()){
			//	propertydetail.setpropertyStat("DEACTIVE");
			}
		}
				session.update(propertydetail);
				transaction.commit();
	      System.out.println("Delete property Successfully");
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void updatepassword(int id, PersonalDetails pd) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails personaldetail=(PersonalDetails)session.get(PersonalDetails.class, id);;
		
		List<PersonalDetails> listpd=session.createQuery("FROM PersonalDetails").list();
		for(int i=0;i<listpd.size();i++){
			PersonalDetails detail=listpd.get(i);
			if(detail.getId()==personaldetail.getId()){
				personaldetail.setFullname(pd.getFullname());
				personaldetail.setUsername(pd.getUsername());
				personaldetail.setEmail(pd.getEmail());
				personaldetail.setPassword(pd.getPassword());
				personaldetail.setPhone(pd.getPhone());
				personaldetail.setStat(pd.getStat());
			}
		}
		session.update(personaldetail);
		System.out.println("update personal detail successfully");
		session.getTransaction().commit();
		session.close();
	}


	public void enable1(int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		//System.out.println(pd1);
		Transaction transaction=null;
		try{ 
		transaction=session.beginTransaction();
		PropertyDetails propertydetail=session.get(PropertyDetails.class,id);
		List<PropertyDetails> listpd=session.createQuery("FROM PropertyDetails").list();
		for(int i=0;i<listpd.size();i++){
			PropertyDetails detail=listpd.get(i);
			if(detail.getPropId()==propertydetail.getPropId()){
			//	propertydetail.setpropertyStat("ACTIVE");
			}
		}
				session.update(propertydetail);
				transaction.commit();
	      System.out.println("Delete property Successfully");
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}


//	public List<PropertyDetails> getLocationList(String location) {
//		// TODO Auto-generated method stub
//		Session session=hibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		List<PropertyDetails> propertyDetail=session.createQuery("FROM PropertyDetails").list();
//		List<PropertyDetails> detail;
//		for(int i=0;i<propertyDetail.size();i++){
//			PropertyDetails property=propertyDetail.get(i);
//			if(property.getLocation()==location){
//				detail.add(property);
//			}
//		}
//		return detail;
//	}


	}

