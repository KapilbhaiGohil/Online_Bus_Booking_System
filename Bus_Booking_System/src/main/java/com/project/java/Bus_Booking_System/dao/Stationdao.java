package com.project.java.Bus_Booking_System.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.Station;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class Stationdao {
	
	private EntityManager e;
	
	@Autowired
	public Stationdao(EntityManager e) {
		super();
		this.e = e;
	}
	
	@Transactional
	public void addStation(double latitude,double longitude,double elevation,String name) {
		Session s = e.unwrap(Session.class);
		Station n = new Station(latitude,longitude,elevation,name);
		s.persist(n);
		s.close();
	}
	
	public Station getStationByName(String name) {
		try {
			TypedQuery<Station> query = e.createQuery("from Station where name ='"+name+"'", Station.class);
			Station st = query.getSingleResult();
			return st;
		}catch(Exception e) {
			System.out.print(e);
			System.out.print("jeldklfosh");
			return null;
		}
		
	}
	
}
