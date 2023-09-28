package com.mobileshoppy.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobileshoppy.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="select * from User where user_name=?1", nativeQuery=true)
	User findByUserName(String UserName);
}