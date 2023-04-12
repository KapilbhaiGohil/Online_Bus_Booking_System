package com.project.java.Bus_Booking_System.components;

public class Email {
	
	private String attachment;
	private String messegebody;
	private String subject;
	private String to;
	public Email(String attachment, String messegebody, String subject, String to) {
		super();
		this.attachment = attachment;
		this.messegebody = messegebody;
		this.subject = subject;
		this.to = to;
	}
	public Email(String messegebody, String subject, String to) {
		super();
		this.messegebody = messegebody;
		this.subject = subject;
		this.to = to;
	}
	public Email() {
		super();
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getMessegebody() {
		return messegebody;
	}
	public void setMessegebody(String messegebody) {
		this.messegebody = messegebody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
}
