package com.mobileshoppy.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile {

	@Id
	private int MobileId;
	private String MobileName;
	private String MobileCompany;
	private int MobilePrice;
}

