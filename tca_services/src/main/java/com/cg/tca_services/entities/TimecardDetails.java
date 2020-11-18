package com.cg.tca_services.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimecardDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)				
		private int project_ID;
	    private int hours;
		private String date;
		private String project_Name;
		private String task_Name;
		private String timecard_Status;
		
		@ManyToOne
		@JoinColumn(name="emp_ID")
		private Employees employee;

		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getProject_ID() {
			return project_ID;
		}
		public void setProject_ID(int project_ID) {
			this.project_ID = project_ID;
		}
		public String getProject_Name() {
			return project_Name;
		}
		public void setProject_Name(String project_Name) {
			this.project_Name = project_Name;
		}
		public String getTask_Name() {
			return task_Name;
		}
		public void setTask_Name(String task_Name) {
			this.task_Name = task_Name;
		}
		public String getTimecard_Status() {
			return timecard_Status;
		}
		public void setTimecard_Status(String timecard_Status) {
			this.timecard_Status = timecard_Status;
		}
		public int getHours() {
			return hours;
		}
		public void setHours(int hours) {
			this.hours = hours;
		}
		public Employees getEmployee() {
			return employee;
		}
		public void setEmployee(Employees employee) {
			this.employee = employee;
		}
	}


