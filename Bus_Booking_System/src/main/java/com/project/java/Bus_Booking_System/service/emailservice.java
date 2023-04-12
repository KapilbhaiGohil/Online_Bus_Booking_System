package com.project.java.Bus_Booking_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.Bus_Booking_System.components.Email;
import com.project.java.Bus_Booking_System.dao.emaildao;

@Service
public class emailservice {
	@Autowired
	private emaildao edao;
	
	public boolean sendmail(Email e) {
		return edao.sendmail(e);
	}
}
