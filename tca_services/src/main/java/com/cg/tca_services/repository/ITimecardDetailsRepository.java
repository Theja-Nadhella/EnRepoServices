package com.cg.tca_services.repository;
import java.util.List;
import com.cg.tca_services.entities.TimecardDetails;

public interface ITimecardDetailsRepository {
	public TimecardDetails findTimecardDetailsById(int project_ID);
	public void addTimecardDetails(TimecardDetails timecard);
	public  List<TimecardDetails> findTimecardDetailsByEmployeeId(long employee_ID);
	public  void updateTimecardStatus(TimecardDetails timecard,String timecard_Status);
	public void beginTransaction();
	public void commitTransaction();
}
