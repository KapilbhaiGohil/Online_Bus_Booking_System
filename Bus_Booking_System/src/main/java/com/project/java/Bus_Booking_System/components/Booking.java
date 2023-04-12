package com.project.java.Bus_Booking_System.components;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private int total_price;
	@ManyToOne(cascade = CascadeType.ALL)
	private Bus bus;
	@Column
	private int[] seatno;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	private int distance; 
	@Column
	private Date journydate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<person> person;
	@Column
	private String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int[] getSeatno() {
		return seatno;
	}
	public void setSeatno(int[] seatno) {
		this.seatno = seatno;
	}
	public String getFrom() {
		return source;
	}
	public void setFrom(String from) {
		this.source = from;
	}
	public String getTo() {
		return destination;
	}
	public void setTo(String to) {
		this.destination = to;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Date getJournydate() {
		return journydate;
	}
	public void setJournydate(Date journydate) {
		this.journydate = journydate;
	}
	public List<person> getPerson() {
		return person;
	}
	public void setPerson(List<person> person) {
		this.person = person;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
