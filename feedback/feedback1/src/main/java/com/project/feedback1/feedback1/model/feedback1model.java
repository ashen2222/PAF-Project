package com.project.feedback1.feedback1.model;

public class feedback1model {

	private int id;
	private String code;
	private String name;
	private String contact;
	private String description;
	public feedback1model(int id, String code, String name, String contact, String description) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.contact = contact;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
	
	
	


	

}
