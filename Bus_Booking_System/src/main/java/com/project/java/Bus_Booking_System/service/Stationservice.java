package com.project.java.Bus_Booking_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.dao.Stationdao;

@Service
public class Stationservice {
	@Autowired
	private Stationdao d;
	
	
	public void addStation(double lati,double longi,double ele,String name) {
		d.addStation(lati, longi, ele,name);
	}
	public Station getStationByName(String name) {
		return d.getStationByName(name);
	}
}
