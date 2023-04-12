package com.project.java.Bus_Booking_System.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.Booking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class bookingdao {
	EntityManager e;

	@Autowired
	public bookingdao(EntityManager e) {
		super();
		this.e = e;
	}
	
	@Transactional
	public void addbooking(Booking b) {
		Session s = e.unwrap(Session.class);
		s.persist(b);
		s.close();
	}
	
	public List<Booking> bookings(String mail){
		List<Booking> c = new ArrayList<>();
		try {
			Query a = e.createNativeQuery("select id from booking where mail = '"+mail+"'");
			List<Integer> ids = a.getResultList();
			System.out.println(ids);
			for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				TypedQuery<Booking> q = e.createQuery("from Booking where id = "+integer, Booking.class);
				Booking go = q.getSingleResult();
				c.add(go);
			}
		}catch(Exception e) {
			System.out.println(e);
			c = null;
		}
		return c;
	}
	
}
