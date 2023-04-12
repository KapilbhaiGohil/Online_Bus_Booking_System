package com.project.java.Bus_Booking_System.service;

import java.net.http.HttpRequest;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.java.Bus_Booking_System.components.Email;
import com.project.java.Bus_Booking_System.components.User;
import com.project.java.Bus_Booking_System.dao.userdao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class userservice {
	@Autowired
	private userdao userdao;
	@Autowired
	private emailservice eservice;
	
	public void adduser(User a) {
		userdao.adduser(a);
	}
	
	public void updateuserpassword(User a) {
		userdao.updateuserpassword(a);
	}
	public User getuserbymail(String e) {
		User a = userdao.getuserbyemail(e);
		return a;
	}
	public User getuserbyusername(String username) {
		return userdao.getuserbyusername(username);
	}
	
	//this is a register part of the user
	public String registeruser(User s,HttpServletRequest req,String cpass,String votp) {
		HttpSession session = req.getSession();
		if(votp == null) {
			if(validatedata(s,session,cpass)) {
				if(validateuser(s,session)) {
					if(sendmail(s,session)) {
						session.setAttribute("user", s);
						return "otpverification";
					}else {
						return "mailerror";
					}
				}else {
					return "register";
				}
			}else {
				return "register";
			}
		}else {
			if(verifyotp(session, votp)) {
				User t = (User) session.getAttribute("user");
				userdao.adduser(t);
				session.removeAttribute("user");
				session.removeAttribute("otp");
				session.removeAttribute("error");
				session.removeAttribute("user");
				return "sucess";
			}else {
				return "otpverification";
			}
		}
	}
	public boolean validatedata(User u,HttpSession s,String conpass) {
//		s.setAttribute("", s);
		if(u.getUsername().contains(" ")) {
			s.setAttribute("error", "username should not contain space ");
			s.setAttribute("user", u);
			return false;
		}
		else if(!u.getPassword().equals(conpass)) {
			s.setAttribute("error", "Password and conform password didn't match ");
			s.setAttribute("user", u);
			return false;
		}else {
			s.removeAttribute("error");
			s.removeAttribute("user");
			return true;
		}
	}
	public boolean validateuser(User u,HttpSession s) {
		if(userdao.getuserbyemail(u.getEmail())!=null) {
			s.setAttribute("error", "user with this email is already exsists");
			s.setAttribute("user", u);
			return false;
		}else if(userdao.getuserbyusername(u.getUsername())!=null){
			s.setAttribute("error", "user with this username is already exists");
			s.setAttribute("user", u);
			return false;
		}else {
			s.removeAttribute("error");
			s.removeAttribute("user");
			return true;
		}
	}
	public boolean sendmail(User s,HttpSession m) {
		try {
			Email e = new Email();
			e.setTo(s.getEmail());
			e.setSubject("OTP verification");
			int min = 100000;
			int max = 999999;
			int random = ThreadLocalRandom.current().nextInt(min, max + 1);
	//		e.setMessegebody("This is your otp for the email verification : "+random);
	//		eservice.sendmail(e);
			System.out.println(random);
			m.setAttribute("otp", random);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean verifyotp(HttpSession s,String votp) {
		try {
			int a = (int)s.getAttribute("otp");
			int b = Integer.valueOf(votp);
			if(a==b) {
				s.removeAttribute("otp");
				s.removeAttribute("error");
				return true;	
			}else{
				s.setAttribute("error", "Pls enter the otp which is sent to your email address");
				return false;
			}
		}catch(Exception e ) {
			return false;
		}
	}
	
	
	//here is the log in part of the application
	public String loginuser(HttpServletRequest req,String username,String password) {
		HttpSession s = req.getSession();
		try {			
			User u = userdao.getuserbyusername(username);
			if(u.getPassword().equals(password)) {
				s.removeAttribute("loginerror");
				s.setAttribute("loginstatus", u);
				return "website/home";
			}else {
				s.setAttribute("loginerror", "username or password didn't match pls try again");
				return "login/login";
			}
		}catch(Exception e) {
			System.out.println("hello from exception of login" + e);
			s.setAttribute("loginerror","username or password didn't match pls try again");
			return "login/login";
		}
		
	}
	//for the forgot password
	public String forgotpass(HttpSession m,String email,String votp) {
			if(votp==null){
				if(userdao.getuserbyemail(email)==null) {
						m.setAttribute("error", "user with this mail doesn't exsist");
						return "login/forgotpass";
				}else {					
					if(sendemail(email,m)) {
						m.setAttribute("email", email);
						m.removeAttribute("error");
						return "login/otp";
					}
					return "login/login";
				}
			}else {
				if(verifyotp(m, votp)) {
					m.setAttribute("verify", "jellodd");
					System.out.print("helol");
					m.removeAttribute("error");
					return "login/forgotpass";
				}else {
					m.setAttribute("error", "Enter the otp sended to your mail address");
					return "login/otp";
				}
			}
			
	}
	public boolean sendemail(String email,HttpSession m) {
		try {
			Email e = new Email();
			e.setTo(email);
			e.setSubject("OTP verification");
			int min = 100000;
			int max = 999999;
			int random = ThreadLocalRandom.current().nextInt(min, max + 1);
//			e.setMessegebody("This is your otp for the email verification : "+random);
//			eservice.sendmail(e);
			System.out.println(random);
			m.setAttribute("otp", random);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
