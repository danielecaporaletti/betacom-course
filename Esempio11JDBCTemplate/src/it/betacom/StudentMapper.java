package it.betacom;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.betacom.model.Student;

public class StudentMapper implements RowMapper<Student> {
	
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	  
      Student student = new Student();
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      
      return student;
   }

}
