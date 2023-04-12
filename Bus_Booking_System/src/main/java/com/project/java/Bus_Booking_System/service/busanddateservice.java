package com.project.java.Bus_Booking_System.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.Bus_Booking_System.components.busanddate;
import com.project.java.Bus_Booking_System.dao.busanddatedao;

@Service
public class busanddateservice {
	@Autowired
	private busanddatedao bd;
	
	public void addbad(busanddate d) {
		bd.adddateandbus(d);
	}
	
	public boolean check(Date d,int busid) {
		return bd.check(d, busid);
	}
	
	
	public boolean[] getseats(Date d,int busid) {
		return bd.getseats(d, busid);
	}
	
	public busanddate getbusanddate(Date d,int busid) {
		return bd.getbusanddate(d, busid);
	}
	
	public void updatebusanddate(busanddate b) {
	  bd.updatedateandbus(b);
	}
}
