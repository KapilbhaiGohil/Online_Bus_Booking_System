package com.project.java.Bus_Booking_System.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class userdao{
	
	private EntityManager e;

	@Autowired
	public userdao(EntityManager e) {
		super();
		this.e = e;
	}
	
	@Transactional
	public void adduser(User s) {
		Session se = e.unwrap(Session.class);
		se.persist(s);
		se.close();
	}
	
//	@Transactional
	public User getuserbyemail(String email) {
//		Session se = e.unwrap(Session.class);
//		NativeQuery<user> q = se.createNativeQuery("select * from user where email='"+email+"';");
		User a;
		try {	
			TypedQuery<User> q = e.createQuery("from User where email = '"+email+"'", User.class);
			 a = (User)q.getSingleResult();
		}catch(Exception e){
			a = null;
		}
		return a;
	}
	
	public User getuserbyusername(String username) {
		User a;
		try {	
			TypedQuery<User> q = e.createQuery("from User where username = '"+username+"'", User.class);
			 a = (User)q.getSingleResult();
			 System.out.println(a);
		}catch(Exception e){
			System.out.println("from userdao getuserby username"+e);
			a = null;
		}
		return a;
	}
	
	@Transactional
	public void updateuserpassword(User a) {
		Session se = e.unwrap(Session.class);
		se.merge(a);
		se.close();
	}
}
