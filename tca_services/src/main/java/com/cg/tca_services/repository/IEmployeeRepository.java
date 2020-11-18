package com.cg.tca_services.repository;
import java.util.List;
import com.cg.tca_services.entities.Employees;

public interface IEmployeeRepository {
	public Employees findEmployeeById(long emp_ID);
	public void addEmployee(Employees employee);
	public List<Employees> findEmployeesUnderSupervisor(long supervisor_ID);
	public void beginTransaction();
	public void commitTransaction();
}
