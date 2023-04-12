package com.project.java.Bus_Booking_System.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.project.java.Bus_Booking_System.components.Email;

@Repository
public class emaildao {
	
	@Autowired
	private JavaMailSender jms;
	@Value("${spring.mail.username}") private String sender;
	
	public boolean sendmail(Email e) {
		try {
			SimpleMailMessage m = new SimpleMailMessage();
			m.setFrom(sender);
			m.setTo(e.getTo());
			m.setSubject(e.getSubject());
			m.setText(e.getMessegebody());
			jms.send(m);
			
			return true;
		}catch(Exception ex){
			return false;
		}
	}
}
