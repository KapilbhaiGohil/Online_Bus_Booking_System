package com.project.java.Bus_Booking_System.service;

import java.sql.Date;
import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.Bus_Booking_System.components.Bus;
import com.project.java.Bus_Booking_System.components.Express;
import com.project.java.Bus_Booking_System.components.Luxary;
import com.project.java.Bus_Booking_System.components.Route;
import com.project.java.Bus_Booking_System.components.Sleeper;
import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.components.Volvo;
import com.project.java.Bus_Booking_System.components.busanddate;
import com.project.java.Bus_Booking_System.dao.Busdao;
import com.project.java.Bus_Booking_System.dao.Routedao;

@Service
public class Busservice {
	
	@Autowired
	private Busdao bdao;
	@Autowired
	private Routedao r;
	@Autowired
	busanddateservice bad;
	
	public void addbus(Bus a) {
		bdao.addbus(a);
	}
	
	public List<Bus> getBusbyroute(Station source,Station dest) {
		List<Bus> bushes = bdao.getbusbySouranddest(source, dest);
		return bushes;
	}
	
	public Bus getbusbyid(int a) {
		return bdao.getbusbyid(a);
	}
	
	public void updatebus(Bus a) {
		bdao.updatebus(a);
	}
	public String getbustypebyid(int id) {
		return bdao.getbustype(id);
	}
	public boolean[] addbusbyjournydate(Date d,Bus bu) {
		if(bu instanceof Volvo) {
			boolean seat[] = new boolean[30];
			busanddate b = new busanddate();
			b.setSeats(seat);
			b.setBus(bu);
			b.setDate(d);
			bad.addbad(b);
			return seat;
		}else if(bu instanceof Sleeper){
			boolean seat[] = new boolean[30];
			busanddate b = new busanddate();
			b.setSeats(seat);
			b.setBus(bu);
			b.setDate(d);
			bad.addbad(b);
			return seat;
		}else if(bu instanceof Express) {
			boolean seat[] = new boolean[50];
			busanddate b = new busanddate();
			b.setSeats(seat);
			b.setBus(bu);
			b.setDate(d);
			bad.addbad(b);
			return seat;
		}else if(bu instanceof Luxary) {
			boolean seat[] = new boolean[40];
			busanddate b = new busanddate();
			b.setSeats(seat);
			b.setBus(bu);
			b.setDate(d);
			bad.addbad(b);
			return seat;
		}
		return null;
	}
	
	public void bookseat(int arr[],Date d,int busid) {
		boolean seat[]=bad.getseats(d, busid);
		for (int i = 0; i < arr.length; i++) {
			seat[arr[i]-1]=true;
		}
		busanddate a = bad.getbusanddate(d, busid);
		a.setSeats(seat);
		bad.updatebusanddate(a);
			
	}
}
