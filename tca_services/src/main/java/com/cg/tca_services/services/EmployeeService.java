package com.cg.tca_services.services;
import java.util.ArrayList;
import java.util.List;
import com.cg.tca_services.entities.Employees;
import com.cg.tca_services.repository.EmployeeRepository;

public class EmployeeService implements IEmployeeService {
	private EmployeeRepository repo;
	public EmployeeService() {
		repo=new EmployeeRepository();
	}

	@Override
	public Employees viewEmployeeById(long emp_ID) {
	 Employees emp=repo.findEmployeeById(emp_ID);
		return emp;
	}
	@Override
	public void addEmployee(Employees employee) {
		repo.addEmployee(employee);		
	}
	@Override
	public boolean validateEmployeeById(long emp_ID) {
		if(emp_ID>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Employees> viewEmployeesUnderSupervisor(long supervisor_ID) {
		List<Employees> emp=repo.findEmployeesUnderSupervisor(supervisor_ID);
		return emp;
	}
	@Override
	public boolean validateSupervisor(long supervisior_ID) {
		List<Employees> emp=new ArrayList<>();
		for(Employees e:emp)
		{
			if(e.getEmp_ID()==supervisior_ID)
			{
				return true;
			}
		}
		return false;
	}
}
