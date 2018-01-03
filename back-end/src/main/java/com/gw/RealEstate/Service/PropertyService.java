package com.gw.RealEstate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gw.RealEstate.DAO.PropertyDAO;
import com.gw.RealEstate.Entity.PersonalDetails;
import com.gw.RealEstate.Entity.PropertyDetails;

@Service
public class PropertyService {

	@Autowired
	private PropertyDAO dao;
	
	public List<PersonalDetails> getdetail() {
		// TODO Auto-generated method stub
		return this.dao.getdetail();
	}

	public void post(PersonalDetails pd) {
		// TODO Auto-generated method stub
		this.dao.post(pd);
	}

	public void update(int id, PersonalDetails pd) {
		// TODO Auto-generated method stub
		this.dao.update(id, pd);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<PropertyDetails> getdetail1() {
		// TODO Auto-generated method stub
		return this.dao.getdetail1();
	}

	public void post1(PropertyDetails pd1,int id) {
		// TODO Auto-generated method stub
		this.dao.post1(pd1,id);
	}

	public void update1(int id, PropertyDetails pd) {
		// TODO Auto-generated method stub
		this.dao.update1(id, pd);
	}

	public void delete1(int id) {
		// TODO Auto-generated method stub
		this.dao.delete1(id);
	}

//	public void addfeature(PropertyFeatures feature, int id) {
//		// TODO Auto-generated method stub
//		this.dao.addfeature(feature,id);
//	}

	public void updatepassword(int id, PersonalDetails pd) {
		// TODO Auto-generated method stub
		this.dao.updatepassword(id,pd);
	}

	public void enable1(int id) {
		// TODO Auto-generated method stub
		this.dao.enable1(id);
	}

//	public List<PropertyDetails> getLocationList(String location) {
//		// TODO Auto-generated method stub
//		return dao.getLocationList(location);
//	}

}
