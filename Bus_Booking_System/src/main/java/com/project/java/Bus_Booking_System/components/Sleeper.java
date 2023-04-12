package com.project.java.Bus_Booking_System.components;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Sleeper")
public class Sleeper extends Bus{
	@Column(name = "max_speed")
	private int speedperhour;
	@Column(name = "price_per_seat")
	private int priceperseat;
	@Column(name = "Total_no_of_seat")
	private boolean[] seats = new boolean[30];
	
	public int getSpeedperhour() {
		return speedperhour;
	}
	public void setSpeedperhour(int speedperhour) {
		this.speedperhour = speedperhour;
	}
	public int getPriceperseat() {
		return priceperseat;
	}
	public void setPriceperseat(int priceperseat) {
		this.priceperseat = priceperseat;
	}
	public boolean[] getSeats() {
		return seats;
	}
	
	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}
	
	
	public Sleeper() {
		super();
	}
	public Sleeper(int speedperhour, int priceperseat) {
		super();
		this.speedperhour = speedperhour;
		this.priceperseat = priceperseat;
	}
}
