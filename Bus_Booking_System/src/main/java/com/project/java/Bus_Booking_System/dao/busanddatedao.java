package com.project.java.Bus_Booking_System.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.Bus;
import com.project.java.Bus_Booking_System.components.busanddate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class busanddatedao {
	private EntityManager e;
	@Autowired
	public busanddatedao(EntityManager e) {
		super();
		this.e = e;
	}
	
	@Transactional
	public void adddateandbus(busanddate b) {
		Session s = e.unwrap(Session.class);
		s.persist(b);
		s.close();
	}
	
	@Transactional
	public void updatedateandbus(busanddate b) {
		Session s = e.unwrap(Session.class);
		s.merge(b);
		s.close();
	}
	
	public boolean check(Date d,int busid) {
		try {
			Query q = e.createNativeQuery("SELECT id from busanddate WHERE date = '"+d+"' and bus_id = "+busid);
			int  a = (int) q.getSingleResult();
			System.out.println(a);
			if(a>0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("line no 46 from bus and date dao");
			return false;
		}
		
	}
	
	public boolean[] getseats(Date d,int busid) {
		try {
			Query temp = e.createNativeQuery("SELECT id from busanddate WHERE date = '"+d+"' and bus_id = "+busid);
			int te = (int) temp.getSingleResult();
			TypedQuery<busanddate> q = e.createQuery("from busanddate WHERE id = "+te, busanddate.class);
//			boolean[] a = (boolean[]) q.getSingleResult();
			busanddate a = q.getSingleResult();
			if(a==null) {
				System.out.println("line 58 form buaanddate dao");
				return null;
			}
			return a.getSeats();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	public busanddate getbusanddate(Date d,int busid) {
		busanddate a;
		try {
			Query temp = e.createNativeQuery("SELECT id from busanddate WHERE date = '"+d+"' and bus_id = "+busid);
			int te = (int) temp.getSingleResult();
			TypedQuery<busanddate> q = e.createQuery("from busanddate WHERE id = "+te, busanddate.class);
//			boolean[] a = (boolean[]) q.getSingleResult();
			a = q.getSingleResult();
			if(a==null) {
				System.out.println("line 58 form buaanddate dao");
				return null;
			}
			return a;
		}catch(Exception e) {
			System.out.println(e);
			a=null;
			return a;
		}
	}
	
}
