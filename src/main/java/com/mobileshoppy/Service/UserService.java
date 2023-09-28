package com.mobileshoppy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobileshoppy.Model.User;
import com.mobileshoppy.Model.Login;
import com.mobileshoppy.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository UserRepo;
	public String Register(User u1) {
		User u=UserRepo.save(u1);
		if(u==null) {
			return null;
		}
		else {
			return "User Saved Sucessfully";
		}
	}
	

	public int Login(Login l1) {

		User u2=UserRepo.findByUserName(l1.getUserName());
	
		if(u2!=null) {
			if(u2.getUserPassword().equals(l1.getUserPassword())) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
		
		
	}
}

