package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.pojo;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Contact {
	private String id;

	@NotBlank(message = "name is required")
	private String name;

	@NotBlank(message = "phone number is required")
	private String phoneNumber;

	public Contact(String id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Contact() {
		this.id = UUID.randomUUID().toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id: " + id + " | name: " + name + " | phone number: " + phoneNumber;
	}
}
