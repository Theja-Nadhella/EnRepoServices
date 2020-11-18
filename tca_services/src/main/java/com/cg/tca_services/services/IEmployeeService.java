package com.cg.tca_services.services;
import com.cg.tca_services.entities.Employees;
import java.util.List;

public interface IEmployeeService {
	public Employees viewEmployeeById(long emp_ID);
	public void addEmployee(Employees employee);
	public boolean validateEmployeeById(long emp_ID);
	public List<Employees> viewEmployeesUnderSupervisor(long supervisor_ID);
	public boolean validateSupervisor(long Supervisor_ID);
}
