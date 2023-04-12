package com.project.java.Bus_Booking_System.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.java.Bus_Booking_System.components.Email;
import com.project.java.Bus_Booking_System.components.User;
import com.project.java.Bus_Booking_System.service.emailservice;
import com.project.java.Bus_Booking_System.service.userservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private userservice uservice;
	@Autowired
	private emailservice eservice;
	
	@RequestMapping(value = {"/","/login"})
	public String login(HttpServletRequest req,String username,String password) {
		if(username ==null || password==null) {
			return "login/login";
		}else {			
			String a = uservice.loginuser(req, username, password);
			return a;
		}
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register/register";
	}
	
	@RequestMapping("/forgotpass")
	public String forgotpass(HttpServletRequest req,String email,String votp) {					
				if(email == null&&votp ==null) {			
					return "login/forgotpass";
				}else {
					String s = uservice.forgotpass(req.getSession(), email, votp);
					return s;
				}
	}
	
	@RequestMapping("/changepass")
	public String chagepass(HttpServletRequest req,String pass1,String pass2) {
		HttpSession s = req.getSession();
		if(pass1.equals(pass2)) {
			s.removeAttribute("error");
			String email = (String) s.getAttribute("email");
			s.removeAttribute("email");
			s.removeAttribute("verify");
			User a = uservice.getuserbymail(email);
			a.setPassword(pass1);
			uservice.updateuserpassword(a);
			return "login/sucess";
		}
		s.setAttribute("error", "Both password didn't match");
		return "login/forgotpass";
	}
	
	@RequestMapping("/validate")
	public String validate(String firstname,String email,String username,String lastname,String password,String cpassword,String votp,HttpServletRequest req) {
		HttpSession s1 = req.getSession();
		User s = new User(firstname,lastname,email,username,password);
		String re =uservice.registeruser(s, req, cpassword,votp);
		return "/register/"+re;
	}
	@RequestMapping("/otpverification")
	public String otpverification(String votp) {
		return "register/sucess";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "website/home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession s = req.getSession();
		s.removeAttribute("loginstatus");
		s.invalidate();
		return "login/logout";
	}
	
}