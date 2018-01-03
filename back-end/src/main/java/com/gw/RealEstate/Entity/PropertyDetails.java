package com.gw.RealEstate.Entity;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="propertydetails")
@Proxy(lazy=false)
public class PropertyDetails {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="propid")
	private int propId;
	@Column(name="title")
	private String title;
	@Column(name="propStatus")
	private String propStatus;
	@Column(name="type")
	private String type;
	@Column(name="area")
	private int area;
	@Column(name="price")
	private int price;
	@Column(name="location")
	private String location;
	@Column(name="superarea")
	private int superarea;
	@Column(name="carpetarea")
	private int carpetarea;

	@Column(name="info")
	private String info;
	@Column(name="building")
	private String building;
	@Column(name="floor")
	private String floor;
	@Column(name="parking")
	private boolean parking;
	@Column(name="furnished")
	private String furnished;
	
	@Column(name="washroom")
	private boolean washroom;
	@Column(name="water")
	private boolean water;
	@Column(name="ac")
	private boolean ac;
	@Column(name="storage")
	private boolean storage;
	
	@Column(name="gaspipe")
	private boolean gaspipe;
	
	@Column(name="alarm")
	private boolean alarm;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	

	@Column(name="phone")
	private long phone;
	
	//@Column(name="propertyStat")
	//private String propertyStat;
	

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private PersonalDetails pd;
	
	public PropertyDetails() {
		
	}
	
	

	public PropertyDetails(String title, String propStatus, String type, int area, int price, String location,int superarea,
			 int carpetarea , String info,String building,String floor,boolean parking,String furnished,boolean washroom,
			 boolean water,boolean ac,boolean storage, boolean gaspipe,boolean alarm,String name, String email, long phone,//String propertyStat,
			  PersonalDetails pd) {
		super();
		this.title = title;
		this.propStatus = propStatus;
		this.type = type;
		this.price = price;
		this.area = area;
		this.location=location;
		this.superarea=superarea;
		this.carpetarea=carpetarea;
		this.info = info;
		this.building = building;
		this.floor = floor;
		this.parking = parking;
		this.furnished = furnished;
		this.washroom = washroom;
		this.water = water;
		
		this.ac = ac;
		this.storage = storage;
		this.gaspipe = gaspipe;
		this.alarm = alarm;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pd = pd;
		//this.propertyStat =propertyStat;
		
		
	}



	public int getPropId() {
		return propId;
	}



	public void setPropId(int propId) {
		this.propId = propId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPropStatus() {
		return propStatus;
	}



	public void setPropStatus(String propStatus) {
		this.propStatus = propStatus;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getArea() {
		return area;
	}



	public void setArea(int area) {
		this.area = area;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getSuperarea() {
		return superarea;
	}



	public void setSuperarea(int superarea) {
		this.superarea = superarea;
	}



	public int getCarpetarea() {
		return carpetarea;
	}



	public void setCarpetarea(int carpetarea) {
		this.carpetarea = carpetarea;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getBuilding() {
		return building;
	}



	public void setBuilding(String building) {
		this.building = building;
	}



	public String getFloor() {
		return floor;
	}



	public void setFloor(String floor) {
		this.floor = floor;
	}



	public boolean isParking() {
		return parking;
	}



	public void setParking(boolean parking) {
		this.parking = parking;
	}



	public String getFurnished() {
		return furnished;
	}



	public void setFurnished(String furnished) {
		this.furnished = furnished;
	}



	public boolean isWashroom() {
		return washroom;
	}



	public void setWashroom(boolean washroom) {
		this.washroom = washroom;
	}



	public boolean isWater() {
		return water;
	}



	public void setWater(boolean water) {
		this.water = water;
	}



	public boolean isAc() {
		return ac;
	}



	public void setAc(boolean ac) {
		this.ac = ac;
	}



	public boolean isStorage() {
		return storage;
	}



	public void setStorage(boolean storage) {
		this.storage = storage;
	}



	public boolean isGaspipe() {
		return gaspipe;
	}



	public void setGaspipe(boolean gaspipe) {
		this.gaspipe = gaspipe;
	}



	public boolean isAlarm() {
		return alarm;
	}



	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public PersonalDetails getPd() {
		return pd;
	}



	public void setPd(PersonalDetails pd) {
		this.pd = pd;
	}
	
	//public String getpropertyStat() {
		//return propertyStat;
	//}



	//public void setpropertyStat(String propertyStat) {
		//this.propertyStat = propertyStat;
	//}


}