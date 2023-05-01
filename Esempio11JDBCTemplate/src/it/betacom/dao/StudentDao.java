package it.betacom.dao;

import java.util.List;

import javax.sql.DataSource;

import it.betacom.model.Student;

public interface StudentDao {
	
	public void setDataSource(DataSource ds);
	public void create(String name, Integer age);
	public Student getStudent(Integer id);
	public List<Student> listStudents();
	public void delete(Integer id);
	public void update(Integer id, Integer age);

}
