package com.gw.RealEstate.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gw.RealEstate.Entity.PersonalDetails;
import com.gw.RealEstate.Entity.PropertyDetails;
import com.gw.RealEstate.SMS.SendSms;
import com.gw.RealEstate.Service.PropertyService;
import com.gw.RealEstate.email.Mail;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService service;
	
	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
	@RequestMapping("/getpersonaldetail")
	public List<PersonalDetails> getdetail(){
		return this.service.getdetail();
	}
	
	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
	@RequestMapping("/getpropertydetail")
	public List<PropertyDetails> getdetail1(){
		return this.service.getdetail1();
	}
//	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
//	@RequestMapping("/getLocationList/{location}")
//	public List<PropertyDetails> getLocationList(@PathVariable String location){
//		return this.service.getLocationList(location);
//	}
	
	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
	@RequestMapping("/otp")
	public String getotp(@RequestBody PersonalDetails pd){
		System.out.println("mail sent");
		//return SendSms.send(pd.getPhone()); 
		return Mail.send(pd.getEmail()); 
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping("/Forgetpassword")
    public String forgetpassword(@RequestBody PersonalDetails personaldetails){
    	return Mail.send(personaldetails.getEmail());
    }
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@PostMapping("/addpersonaldetail")
	public void addprop(@RequestBody PersonalDetails pd ){
	service.post(pd);
		
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@PostMapping("/addpropertydetail/{id}")
	public void addprop1(@RequestBody PropertyDetails pcd,@PathVariable int id ){
		service.post1(pcd,id);
		//Mail.send(pcd.getEmail());
		
	}
	
//	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
//	@PostMapping("/addfeaturedetail/{id}")
//	public String addfeature(@RequestBody PropertyFeatures feature,@PathVariable int id ){
//		service.addfeature(feature,id);
//		return "Added";
//	}
	
//    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
//    @PutMapping("/updateldetail/{id}")
//    public void updateprop(@RequestBody PersonalDetails pd, @PathVariable int id){
//    	service.update(id,pd);
//    }
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PutMapping("/updatepassword/{id}")
    public void updatepassword(@RequestBody PersonalDetails pd, @PathVariable int id){
    	service.updatepassword(id,pd);
    }
	
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PutMapping("/updatepropertydetail/{id}")
    public void updateprop1(@RequestBody PropertyDetails pd, @PathVariable int id){
    	service.update1(id,pd);
    }
    
//    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
//    @DeleteMapping("/deletedetail/{id}")
//    public void deleteprop(@PathVariable int id){
//    	service.delete(id);
//    }
   
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @DeleteMapping("/deletepropertydetail/{id}")
    public void deleteprop1(@PathVariable int id){
    	service.delete1(id);
    }
    
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @DeleteMapping("/enablepropertydetail/{id}")
    public void enableprop1(@PathVariable int id){
    	service.enable1(id);
    }
    
}
