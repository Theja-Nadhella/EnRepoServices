package com.cg.tca_services.repository;

import com.cg.tca_services.entities.Employees;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class EmployeeRepository implements IEmployeeRepository {
		private EntityManagerFactory entityManagerFactory;
		private EntityManager entityManager;
		
		public  EmployeeRepository() {
			entityManagerFactory = JPAUtil.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();					
		}

		@Override
		public Employees findEmployeeById(long emp_ID) {
			Employees entity = entityManager.find(Employees.class,emp_ID);
			Employees employee = new Employees();
			employee.setEmp_ID(entity.getEmp_ID());
			employee.setEmp_Name(entity.getEmp_Name());
			employee.setPhone_Number(entity.getPhone_Number());
			employee.setEmp_Email(entity.getEmp_Email());
			employee.setTimecard(entity.getTimecard());
			return employee;
		}
		@Override
		public void addEmployee(Employees employee) {
			beginTransaction();
			Employees entity = new Employees();
			employee.setEmp_ID(entity.getEmp_ID());
			employee.setEmp_Name(entity.getEmp_Name());
			employee.setPhone_Number(entity.getPhone_Number());
			employee.setEmp_Email(entity.getEmp_Email());
			employee.setSupervisor_ID(entity.getSupervisor_ID());
			employee.setTimecard(entity.getTimecard());
			
			entityManager.persist(entity);
			commitTransaction();
			
		}

		@Override
		public List<Employees> findEmployeesUnderSupervisor(long supervisor_ID) {
			
			TypedQuery<Employees> query  = entityManager.createQuery(
		          "SELECT * FROM Employees WHERE superisor_ID=supervisorID", Employees.class);
			List<Employees> resultList = query.getResultList();
			return resultList;
		}
		
		@Override
		public void beginTransaction() {

			entityManager.getTransaction().begin();
			
		}

		@Override
		public void commitTransaction() {
			entityManager.getTransaction().commit();
			
		}
}
