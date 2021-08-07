package com.javen.model;

public class Login {
	
	private Integer id;
	private String phone;
	private String password;
	private int type;

	@Override
	public String toString() {
		return "Login{" +
				"id=" + id +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", type=" + type +
				'}';
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


	
	
	
}
