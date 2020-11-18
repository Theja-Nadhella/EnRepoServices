package com.cg.tca_services.repository;
import com.cg.tca_services.entities.TimecardDetails;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TimecardDetailsRepository implements ITimecardDetailsRepository {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public TimecardDetailsRepository() {
		entityManagerFactory = JPAUtil.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();		
	}
	@Override
	public TimecardDetails findTimecardDetailsById(int project_ID) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class,project_ID);
		TimecardDetails timecard = new TimecardDetails();
		timecard.setProject_ID(entity.getProject_ID());
		timecard.setHours(entity.getHours());
		timecard.setDate(entity.getDate());
		timecard.setProject_Name(entity.getProject_Name());
		timecard.setTask_Name(entity.getTask_Name());
		timecard.setTimecard_Status(entity.getTimecard_Status());
		return timecard;
	}
	@Override
	public List<TimecardDetails> findTimecardDetailsByEmployeeId(long employee_ID) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class,employee_ID);
		List<TimecardDetails> timecard = new ArrayList<>();
		for(TimecardDetails td: timecard) {
			td.setProject_ID(entity.getProject_ID());
			td.setHours(entity.getHours());
			td.setDate(entity.getDate());
			td.setProject_Name(entity.getProject_Name());
			td.setTask_Name(entity.getTask_Name());
			td.setTimecard_Status(entity.getTimecard_Status());
		timecard.add(td);
		}
		return timecard;
	}
	@Override
	public void addTimecardDetails(TimecardDetails timecard) {
		beginTransaction();
		TimecardDetails entity = new TimecardDetails();
		timecard.setProject_ID(entity.getProject_ID());
		timecard.setHours(entity.getHours());
		timecard.setDate(entity.getDate());
		timecard.setProject_Name(entity.getProject_Name());
		timecard.setTask_Name(entity.getTask_Name());
		timecard.setTimecard_Status(entity.getTimecard_Status());
		entityManager.persist(entity);
		commitTransaction();		
	}
	@Override
	public void updateTimecardStatus(TimecardDetails timecard,String timecard_Status) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class, timecard.getProject_ID());
		if(entity.getTimecard_Status().equalsIgnoreCase("Pending")) {
			beginTransaction();
			entity.setTimecard_Status(timecard_Status);
			commitTransaction();
		}
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

