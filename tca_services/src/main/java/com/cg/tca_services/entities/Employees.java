package com.cg.tca_services.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Employees {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long emp_ID;
	private String emp_Name;
	private String phone_Number;
	private String emp_Email;
	private long supervisor_ID;
	
	@OneToMany(mappedBy="employees")
	private List<TimecardDetails> timecard=new ArrayList<>();
	
	/**
	 * Create getters and setter methods
	 * Purpose : getter reads the value of a variable, setter updates the value of a variable 
	 */
	public long getSupervisor_ID() {
		return supervisor_ID;
	}
	public void setSupervisor_ID(long supervisor_ID) {
		this.supervisor_ID = supervisor_ID;
	}
	public Long getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(Long emp_ID) {
		this.emp_ID = emp_ID;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public String getPhone_Number() {
		return phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}
	public String getEmp_Email() {
		return emp_Email;
	}
	public void setEmp_Email(String emp_Email) {
		this.emp_Email = emp_Email;
	}
	public List<TimecardDetails> getTimecard() {
		return timecard;
	}
	public void setTimecard(List<TimecardDetails> timecard) {
		this.timecard = timecard;
	}	
	}
