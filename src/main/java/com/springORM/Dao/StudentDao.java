package com.springORM.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	
	// To add Student
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;

	}
	
	// To Get Single Student
	public Student getStudent(int studentID)
	{
	Student student =this.hibernateTemplate.get(Student.class,studentID);
	return student;
	}
	
	// To Get All Students
	public List<Student> getAllStudents()
	{
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	// To Delete Student Data
	@Transactional
	public void deleteStudent(int studentID)
	{
	Student student = this.hibernateTemplate.get(Student.class,studentID);
		this.hibernateTemplate.delete(student);
	}
	
	// To Update Student Details
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
