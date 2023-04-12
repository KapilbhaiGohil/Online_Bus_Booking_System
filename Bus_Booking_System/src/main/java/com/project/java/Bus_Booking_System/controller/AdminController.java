package com.project.java.Bus_Booking_System.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.java.Bus_Booking_System.components.Bus;
import com.project.java.Bus_Booking_System.components.Express;
import com.project.java.Bus_Booking_System.components.Luxary;
import com.project.java.Bus_Booking_System.components.Route;
import com.project.java.Bus_Booking_System.components.Sleeper;
import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.components.Volvo;
import com.project.java.Bus_Booking_System.service.Busservice;
import com.project.java.Bus_Booking_System.service.Routeservice;
import com.project.java.Bus_Booking_System.service.Stationservice;
import com.project.java.Bus_Booking_System.service.userservice;

@Controller
public class AdminController {
	@Autowired
	private userservice uservice;
	@Autowired
	private Stationservice s;
	@Autowired
	private Routeservice r;
	@Autowired
	private Busservice bs;
	
	@RequestMapping("/addStationnot")
	public void addStation() {
//		s.addStation(22.307149570164675, 73.18121242023174,37,"VADODARA");
//		s.addStation(22.696653963301923, 72.86223297201494,59,"NADIAD");
//		s.addStation(23.01414951075558, 72.59232890388382,71,"AHMEDABAD");
//		s.addStation(21.77022299279024, 72.13679532049923,26,"BHAVNAGAR");
// 		s.addStation(22.696653963301923, 72.86223297201494,59,"NADIAD");
			
	}
	
	@RequestMapping("/addRoute")
	public void addroute() {
		Time dept = Time.valueOf("08:00:00");
		Time dest = Time.valueOf("10:30:00");
		List<Station> st = new ArrayList<>();
		st.add(s.getStationByName("VADODARA"));
		st.add(s.getStationByName("NADIAD"));
		st.add(s.getStationByName("BHAVNAGAR"));
		st.add(s.getStationByName("AHMEDABAD"));
		System.out.print(st);
//		r.addroute(dept, dest, st, st.get(0), st.get(st.size()-1));
	}
	
	@RequestMapping("/addbus")
	public void addbus() {
		Volvo a = new Volvo();
		Date d = Date.valueOf("2023-04-05");
		Route n = r.getroutebyid(4);
		a.setRoute(n);
		a.setName("1515VPIBHJSLVLV");
		int price = (int)n.getDistance()*4;//4 for volvo 3 for luxary and 2 for express 5 for sleeper
		a.setPriceperseat(price);
		a.setSpeedperhour(70);
		System.out.println(a.getPriceperseat());
		bs.addbus(a);
	}
}
