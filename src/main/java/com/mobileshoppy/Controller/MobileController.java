package com.mobileshoppy.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileshoppy.Model.Mobile;
import com.mobileshoppy.Service.MobileService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MobileController {

	@Autowired
	MobileService Service;
	
	@RequestMapping(method=RequestMethod.POST, value="/Mobile")
	public ResponseEntity<String>addMobile(@RequestBody Mobile m1) {
		
		String status=Service.saveMobile(m1);
		
		if(status==null) {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/Mobile")
	public ResponseEntity<List<Mobile>> getMobile(){
		 return new ResponseEntity<>(Service.getMobile(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatemobile")
	public ResponseEntity<String> updateMobile(@RequestBody Mobile m2) {
		String status= Service.updateMobile(m2);
		if(status==null) {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/mobile/{id}")
	public ResponseEntity<String> deleteMobile(@PathVariable int id) {

		String status= Service.deleteMobile(id);
		if(status==null) {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		}
	}
	
	@GetMapping("mobile/{id}")
	public ResponseEntity<Optional<Mobile>> getMobilebyId(@PathVariable int id) {
		Optional<Mobile> m1= Service.getMobilebyId(id);
		if(m1.isEmpty()) {

			return new ResponseEntity<>(m1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(m1,HttpStatus.ACCEPTED);
					
		}
		
		
	}
	
	
}




