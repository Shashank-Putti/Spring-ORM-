package com.springORM.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentDetails")
public class Student {

	@Id
	private int studentId;
	private String studentname;
	private String studentcity;
	public Student(int studentId, String studentname, String studentcity) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.studentcity = studentcity;
	}
	public Student() {
		super();
		
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentcity() {
		return studentcity;
	}
	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}
	
	

}
