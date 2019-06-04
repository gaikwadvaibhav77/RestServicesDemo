package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name ="student")
public class Student {
	@ApiModelProperty(notes = "id of the Student", name = "id", required = true, value = "test id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ApiModelProperty(notes = "Name of the Student", name = "name", required = true, value = "test name")
	@NotBlank
	@Column(nullable = false)
	private String name;
	@ApiModelProperty(notes = "Class of the Student", name = "cls", required = true, value = "test class")
	private String cls;
	@ApiModelProperty(notes = "Country of the Student", name = "country", required = true, value = "test country")
	private String country;

	public Student(String name, String cls, String country) {
		super();
		this.name = name;
		this.cls = cls;
		this.country = country;
	}
	Student(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cls=" + cls + ", country=" + country + "]";
	}
}
