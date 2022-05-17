package com.alienhub.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aliens")
public class UserModal {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	private long alienId;
@Column
	private String name;
	@Column
	private String email;
	@Column
	private Timestamp creation_time;
	@Column

	private String dob;
	@Column
	private String password;
	@Column	
	private String location;
	

	
	public long getAlienId() {
		return alienId;
	}

	public void setAlienId(long alienId) {
		this.alienId = alienId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Timestamp creation_time) {
		this.creation_time = creation_time;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}
