package com.usermanagement.system.dto;

public class RegisterRequest {

	private String name;
	
	private String email;
	
	private String password;
	
	private String age;

	public RegisterRequest() {
		super();
	}

	public RegisterRequest(String name, String email, String password, String age) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "RegisterRequest [name=" + name + ", email=" + email + ", password=" + password + ", age=" + age + "]";
	}
	
	
}
