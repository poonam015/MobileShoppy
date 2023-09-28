package com.mobileshoppy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mobileshoppy.Model.Mobile;

@Repository
public interface MobileRepo extends JpaRepository<Mobile, Integer> {

}
