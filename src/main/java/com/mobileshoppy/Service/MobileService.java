package com.mobileshoppy.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileshoppy.Model.Mobile;
import com.mobileshoppy.Repository.MobileRepo;

@Service
public class MobileService {

	@Autowired
	MobileRepo repo; 
	
	public String saveMobile(Mobile m1) {
		Mobile m=repo.save(m1);
		if(m!=null)
		{
		return "Mobile is Added";
		}
		else {
			return null;
		}
		
	}

	public List<Mobile> getMobile(){
		List<Mobile> mobilelist=new ArrayList<>();
		
		repo.findAll().forEach(mobilelist::add);
		
		return mobilelist;
	}
	
	public String updateMobile(Mobile m2) {
		Mobile m=repo.save(m2);
		if(m!=null) {
			return "Mobile Updated";
		}
		else {
			return null;
		}
		
	}
	
	
	
	public String deleteMobile(int mobileid) {
		
		Optional<Mobile> m1=repo.findById(mobileid);
	
		if(m1==null) {
			return null;
		}
		else {
			repo.deleteById(mobileid);
			return "Mobile Deleted";
		}
		
	}
	
	public Optional<Mobile> getMobilebyId(int id) {
		return repo.findById(id);
	}
	
}