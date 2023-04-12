package com.project.java.Bus_Booking_System.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.Bus;
import com.project.java.Bus_Booking_System.components.Express;
import com.project.java.Bus_Booking_System.components.Luxary;
import com.project.java.Bus_Booking_System.components.Route;
import com.project.java.Bus_Booking_System.components.Sleeper;
import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.components.Volvo;
import com.project.java.Bus_Booking_System.service.Routeservice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class Busdao {
	
	private EntityManager e;
	@Autowired
	private Routeservice rservice;
	
	@Autowired
	public Busdao(EntityManager e) {
		this.e = e;
	}
	
	@Transactional
	public void addbus(Bus a) {
		Session s = e.unwrap(Session.class);
		s.persist(a);
		s.close();
	}
	
	public Bus getbusbyid(int a) {
		TypedQuery<Bus> q = e.createQuery("from Bus where id = "+a, Bus.class);
		Bus c = q.getSingleResult();
		return c;
	}
	
	@Transactional
	public void updatebus(Bus a) {
		Session s = e.unwrap(Session.class);
		s.merge(a);
		s.close();
	}
	 
	public String getbustype(int ja) {
		Query busque = e.createNativeQuery("SELECT bus_type from bus WHERE id = "+ja);
		String s = (String) busque.getSingleResult();
		return s;
	}
	
	public List<Bus> getbusbySouranddest(Station source,Station dest) {
		List<Bus> b = new ArrayList<Bus>();
		List<Route> routelist=new ArrayList<Route>();
		try {
			System.out.println(source.getId());
			Query q = e.createNativeQuery("SELECT DISTINCT route_id FROM route_stations WHERE stations_id= "+source.getId()+" OR stations_id= "+dest.getId());
			List<Integer> numbers = q.getResultList();
			System.out.println(numbers);
			for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
				Integer i = (Integer) iterator.next();
				Route a = rservice.getroutebyid(i);
				List<Station> sts = a.getStations();
				System.out.println("this is a sts and route : "+sts+" "+a);
				boolean so = false;
				boolean de = false;
				for (Iterator iterator2 = sts.iterator(); iterator2.hasNext();) {
					Station station = (Station) iterator2.next();
					System.out.println(station.getName());
					if(station.equals(source)) {
						so = true;
					}
					if(so==true && station.equals(dest)) {
						de=true;
					}
					if(so&&de) {
						routelist.add(a);
						System.out.println(a.getId());
						Query busque = e.createNativeQuery("SELECT * FROM `bus` WHERE route_id = "+a.getId(), Bus.class);
						b = busque.getResultList();
						break;
					}
				}
				
			}
			System.out.println("this is a route : "+routelist);
			System.out.print("this is a bus : "+b);
		}catch(Exception e) {
			System.out.print(e);
			 b = null;
		}
		return b;
	}
	
	@Transactional
	public Bus addbusbyjournydate(Bus d) {
		Session s = e.unwrap(Session.class);
		s.persist(d);
		s.close();
		return d;
	}
}
