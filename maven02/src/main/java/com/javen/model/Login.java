package com.javen.model;

public class Login {
	
	private Integer id;
	public String phone;
	private String passWord;
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login{" +
				"id=" + id +
				", phone='" + phone + '\'' +
				", passWord='" + passWord + '\'' +
				", type=" + type +
				'}';
	}
}
