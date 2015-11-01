package com.kasibsblog.spring.web.dao;

public class Person {

	private int id;
	private String firstname;
	private String lastname;
	private String occupation;

	public Person() {
	}

	public Person(int id, String firstname, String lastname, String occupation) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.occupation = occupation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
