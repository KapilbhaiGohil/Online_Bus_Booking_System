package com.project.java.Bus_Booking_System.controller;

import java.lang.ProcessBuilder.Redirect;
import java.net.http.HttpRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.java.Bus_Booking_System.components.Booking;
import com.project.java.Bus_Booking_System.components.Bus;
import com.project.java.Bus_Booking_System.components.Express;
import com.project.java.Bus_Booking_System.components.Luxary;
import com.project.java.Bus_Booking_System.components.Sleeper;
import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.components.User;
import com.project.java.Bus_Booking_System.components.Volvo;
import com.project.java.Bus_Booking_System.components.person;
import com.project.java.Bus_Booking_System.service.Busservice;
import com.project.java.Bus_Booking_System.service.Routeservice;
import com.project.java.Bus_Booking_System.service.Stationservice;
import com.project.java.Bus_Booking_System.service.bookingservice;
import com.project.java.Bus_Booking_System.service.busanddateservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class WebsiteController {
	 
	@Autowired
	Routeservice r;
	@Autowired
	Busservice b;
	@Autowired
	Stationservice st;
	@Autowired
	busanddateservice bad;
	@Autowired
	bookingservice boservice;
	
	@RequestMapping("/searchresult")
	public String searchresult(HttpServletRequest req,String source,String destination,Date date,int noseat) {
		HttpSession s = req.getSession();
		try {
			
			System.out.println();
			System.out.println(source+ destination+date);
			Station so = st.getStationByName(source);
			Station dest = st.getStationByName(destination);
			List<Bus> bushes = b.getBusbyroute(so, dest);
			List<Volvo> vo = new ArrayList<Volvo>();
			List<Sleeper> sl = new ArrayList<Sleeper>();
			List<Express> ex = new ArrayList<Express>();
			List<Luxary> lu = new ArrayList<Luxary>();
			for (Iterator iterator = bushes.iterator(); iterator.hasNext();) {
				Bus bus = (Bus) iterator.next();
				System.out.println("this is a bus " + bus.getId());
				if(bus instanceof Volvo) {
					if(bad.check(date, bus.getId())) {
						boolean sea[]=bad.getseats(date, bus.getId());
						((Volvo)bus).setSeats(sea);
						System.out.println("True");
						System.out.println(bus);
						vo.add((Volvo) bus);
					}else {
						boolean seat[] = b.addbusbyjournydate(date, bus);
						((Volvo) bus).setSeats(seat);
						vo.add((Volvo) bus);
					}
				}else if(bus instanceof Sleeper) {
					if(bad.check(date, bus.getId())) {
						boolean sea[]=bad.getseats(date, bus.getId());
						((Sleeper)bus).setSeats(sea);
						
						System.out.println("True");
						System.out.println(bus);
						sl.add((Sleeper) bus);
					}else {
						boolean seat[] = b.addbusbyjournydate(date, bus);
						((Sleeper) bus).setSeats(seat);
						sl.add((Sleeper) bus);
					}
				}else if(bus instanceof Express) {
					if(bad.check(date, bus.getId())) {
						boolean sea[]=bad.getseats(date, bus.getId());
						((Express)bus).setSeats(sea);
						
						System.out.println("True");
						System.out.println(bus);
						ex.add((Express) bus);
					}else {
						boolean seat[] = b.addbusbyjournydate(date, bus);
						((Express) bus).setSeats(seat);
						ex.add((Express) bus);
					}
				}else if(bus instanceof Luxary){
					if(bad.check(date, bus.getId())) {
						boolean sea[]=bad.getseats(date, bus.getId());
						((Luxary)bus).setSeats(sea);
						System.out.println("True");
						System.out.println(bus);
						lu.add((Luxary) bus);
					}else {
						boolean seat[] = b.addbusbyjournydate(date, bus);
						((Luxary) bus).setSeats(seat);
						lu.add((Luxary) bus);
					}
				}
			}
			if(vo.size()+lu.size()+ex.size()+sl.size()==0) {
				return "website/error";
			}
			double dist = r.calculateDistance(so.getLatitude(), so.getLongitude(), so.getElevation(), dest.getLatitude(), dest.getLongitude(), dest.getElevation());
			double duvolu = dist/70;
			int sd = (int)duvolu;
			duvolu-=sd;
			int minu=(int)(duvolu*60);
			String time = sd + ":"+minu;
			double dusl = (dist/75);
			int sd1 = (int)dusl;
			duvolu-=sd;
			int minu1=(int)(dusl*60);
			String time1 = sd1 + ":"+minu1;
			double duex = (dist/65);
			int sd2 = (int)duex;
			duvolu-=sd;
			int minu2=(int)(duex*60);
			String time2 = sd2 + ":"+minu2;
			
			s.setAttribute("duvolu", time);
			s.setAttribute("dusl", time1);
			s.setAttribute("duex", time2);
			s.setAttribute("dist", dist);
			s.setAttribute("volvo", vo);
			s.setAttribute("express", ex);
			s.setAttribute("sleeper", sl);
			s.setAttribute("luxary", lu);
			s.setAttribute("boo", true);
			s.setAttribute("jourdate", date);
			s.setAttribute("noseat", noseat);
			s.setAttribute("so", so);
			s.setAttribute("dest", dest);
			return "website/searchresult";
		}catch(Exception e) {
			return "website/error";
		}
	}
	
	@RequestMapping("/seatbook")
	public String seatbook(int price,String type,int[] selected,String[] name,String[] gender,int[] age,int busid,Date jourdate,HttpServletRequest req) {
		HttpSession s = req.getSession();
		List<person>p = new ArrayList<>();
		for (int i = 0; i < selected.length; i++){
			System.out.println(selected[i]);
			person p1 = new person();
			p1.setName(name[i]);
			p1.setAge(age[i]);
			p1.setGender(gender[i]);
			p.add(p1);
		}
		Bus newbus;
		if(type.equals("sleeper")){
			newbus = (Sleeper) b.getbusbyid(busid);
		}else if(type.equals("volvo")){
			newbus = (Volvo) b.getbusbyid(busid);
		}else if(type.equals("express")) {
			newbus = (Express) b.getbusbyid(busid);
		}else {
			newbus = (Luxary) b.getbusbyid(busid);
		}
		//afterpayment process
		Station so = (Station) req.getSession().getAttribute("so");
		Station dest = (Station) req.getSession().getAttribute("dest");
		double dist = (double) req.getSession().getAttribute("dist");
		Booking newbooking = new Booking();
		newbooking.setBus(b.getbusbyid(busid));
		newbooking.setDistance((int)(dist));
		newbooking.setFrom(so.getName());
		newbooking.setJournydate(jourdate);
		newbooking.setPerson(p);
		newbooking.setSeatno(selected);
		newbooking.setTo(dest.getName());
		newbooking.setTotal_price(price*selected.length);
		User us = (User) req.getSession().getAttribute("loginstatus");
		newbooking.setMail(us.getEmail());
		boservice.addbooking(newbooking);
		b.bookseat(selected, jourdate, busid);
		return "website/sucess";
	}
	@RequestMapping("/checkticket")
	public String checkticket(HttpServletRequest req) {
		try {
			User a = (User) req.getSession().getAttribute("loginstatus");
			List<Booking> bookings = boservice.book(a.getEmail());
			System.out.println(bookings);
			req.getSession().setAttribute("Bookings", bookings);
		}catch(Exception e) {
			return "redirect:/login";
		}
		return "website/bill";
	}
	
}
