package com.jci.service;

import java.util.List;

import com.jci.model.VerifyTallySlip;
public interface VerifyTallySlipService {
	public void create(VerifyTallySlip VerifyTallySlip);
	public void update(VerifyTallySlip VerifyTallySlip);
	public VerifyTallySlip edit(int id);
	public void delete(int id);
	public VerifyTallySlip find(int id);
	public List<VerifyTallySlip> getAll(String status);
	public boolean submitform(VerifyTallySlip VerifyTallySlip);

	public String GettransectionDetails(String tallyNo);
//	public VerifyTallySlip findByTally(String tallyslipno);
	public boolean updatebyTally(String status, int verified,String tallyno);
}
