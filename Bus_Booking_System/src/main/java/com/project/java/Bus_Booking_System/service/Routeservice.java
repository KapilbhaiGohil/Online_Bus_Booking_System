package com.project.java.Bus_Booking_System.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.Bus_Booking_System.components.Route;
import com.project.java.Bus_Booking_System.components.Station;
import com.project.java.Bus_Booking_System.dao.Routedao;

@Service
public class Routeservice {
	
	@Autowired
	Routedao r;
	
	public double calculateDistance(double lat1, double lon1, double elev1, double lat2, double lon2, double elev2) {
        int R = 6371000; // Earth's radius in meters
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2)
                + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        double h1 = elev1;
        double h2 = elev2;
        double dH = h2 - h1;
        double distance = Math.sqrt(d * d + dH * dH);
        return (distance/1000)*2.3;
    }
	public void addroute(Time ti,Time dest,List<Station> list,Station source,Station fin) {
		Route a = new Route();
		a.setBustype("Volvo");
		a.setDepttime(ti);
		a.setDesttime(dest);
		a.setStations(list);
		double dist = calculateDistance(source.getLatitude(), source.getLongitude(), source.getElevation(), fin.getLatitude(), fin.getLongitude(), fin.getElevation());
		a.setDistance(dist);
		a.setStations(list);
		System.out.println(a.toString());
		r.addRoute(a);
	}
	public Route getroutebyid(int id) {
		return r.getroutebyid(id);
	}

	
}