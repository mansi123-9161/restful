package com.mansi.webservice.restful.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {

	private Integer id;
	@Size(min = 2, message = "name should have atleast 2 charectors")
	private String name;
	@Past
	private Date birthDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public UserBean(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
}
