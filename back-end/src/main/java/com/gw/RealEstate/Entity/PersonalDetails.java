package com.gw.RealEstate.Entity;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="personaldetails")
@Proxy(lazy=false)
public class PersonalDetails {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="username")
	private String username;
	
	@Column (name="email")
	private String email;
	
	@Column (name="password")
	private String password;
	
	@Column(name="phone")
	private long phone;
	
	@Column (name="stat")
	private String stat;
	
	
	
	public PersonalDetails() {
		
	}

	public PersonalDetails(String fullname, String username, String email, String password, long phone, String stat) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.stat = stat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

//	public PropertyDetails getPd() {
//		return pd;
//	}
//
//	public void setPd(PropertyDetails pd) {
//		this.pd = pd;
//	}



}
