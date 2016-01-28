package com.elead.training;

import java.util.Set;

public class Student {

	private String name;
	private String Email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		
		return name+","+Email;
	}
	
}
