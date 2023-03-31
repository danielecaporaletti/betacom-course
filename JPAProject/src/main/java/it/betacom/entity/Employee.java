package it.betacom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mySeqGen")

    private int eid;

    private String ename;

    private double salary;

    private String deg;

    public Employee() {

	super();

    }

    public int getEid() {
	return eid;
    }

    public void setEid(int eid) {
	this.eid = eid;
    }

    public String getEname() {
	return ename;
    }

    public void setEname(String ename) {
	this.ename = ename;
    }

    public double getSalary() {
	return salary;
    }

    public void setSalary(double salary) {
	this.salary = salary;
    }

    public String getDeg() {
	return deg;
    }

    public void setDeg(String deg) {
	this.deg = deg;
    }

    @Override
    public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
    }

}