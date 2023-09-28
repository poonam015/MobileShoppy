package com.mobileshoppy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mobileshoppy.Model.User;
import com.mobileshoppy.Model.Login;
import com.mobileshoppy.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService Service;
	
	@PostMapping("/Register")
	public ResponseEntity<String> Login(@RequestBody User u1) {
		
		String Status=Service.Register(u1);
		if(Status==null) {
			return new ResponseEntity<>(Status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(Status,HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/Login")
	public ResponseEntity<String> Login(@RequestBody Login l1) {
		
		int i=Service.Login(l1);
		if(i==1) {
			return new ResponseEntity<>("Login Success",HttpStatus.ACCEPTED);
		}
		else {
			if(i==0) {
				return new ResponseEntity<>("Wrong Credentials",HttpStatus.FORBIDDEN);
			}
			else {
				return new ResponseEntity<>("User Not Registered",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
}
