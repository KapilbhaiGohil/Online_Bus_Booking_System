package com.project.java.Bus_Booking_System.components;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Route {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Station> stations = new ArrayList<Station>();
	@Column
	private double distance;
	@Column
	private Time depttime;
	@Column
	private Time desttime;
	@Column
	private String bustype;
	
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		
		this.stations = stations;
	}
	public Time getDepttime() {
		return depttime;
	}
	public void setDepttime(Time depttime) {
		this.depttime = depttime;
	}
	public Time getDesttime() {
		return desttime;
	}
	public void setDesttime(Time desttime) {
		this.desttime = desttime;
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
@Override
	public String toString() {
		return "Route [id=" + id + ", stations=" + stations + ", distance=" + distance + ", depttime=" + depttime
				+ ", desttime=" + desttime + ", bustype=" + bustype + "]";
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
