package com.cg.tca_services.services;
import com.cg.tca_services.entities.TimecardDetails;
import java.util.List;

public interface ITimecardDetailsService {
	public void addTimecardDetails(TimecardDetails timecard);
	public  void updateTimecardStatus(TimecardDetails timecard,String timecard_Status);
	public List<TimecardDetails> viewTimecardDetailsByEmployeeId(long employee_ID);
}
