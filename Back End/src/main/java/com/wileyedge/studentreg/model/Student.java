package com.wileyedge.studentreg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mystudents")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name") // the name here will be the column name
	@Size(min=3,message="Name must have at least 3 chars") // validation
	@NotBlank(message = "Name is mandatory")
	private String name;
	@Column(name = "age") 
	private int age;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "address")
	private String address;
	
	public Student() {
	}
	
	public Student(String name, int age, String mobile, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobile=" + mobile + ", address=" + address + "]";
	}
	
	
	

}
