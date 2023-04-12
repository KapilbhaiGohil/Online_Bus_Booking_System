package com.project.java.Bus_Booking_System.components;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private double longitude;
	@Column
	private double latitude;
	
	@ManyToMany(mappedBy = "stations")
	private List<Route> route;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	private double elevation;

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public Station(double longitude, double latitude, double elevation,String name) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.elevation = elevation;
		this.name = name;
	}
	
	public Station() {
		super();
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Station(int id, double longitude, double latitude, double elevation) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.elevation = elevation;
	}
	
	
}
