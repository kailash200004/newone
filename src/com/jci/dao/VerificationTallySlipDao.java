package com.jci.dao;

import java.util.List;

import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.VerifyTallySlip;

public interface VerificationTallySlipDao {
	public void create(VerifyTallySlip verifyTallySlip);
	public void update(VerifyTallySlip verifyTallySlip);
	public VerifyTallySlip edit(int id);
	public void delete(int id);
	public VerifyTallySlip find(int id);
	public List <VerifyTallySlip> getAll(String status);
	public boolean submitform(VerifyTallySlip verifyTallySlip);
	public String GettransectionDetails(String tallyNo, String region);
	//public  VerifyTallySlip findByTally(String tallyslipno);
	public boolean updatebyTally(String status, int verified,String tallyno);
	public PaymentprocesstellyslipModel updatepaymentstatusbytally(String tno);
	public void savepaymentdata(PaymentprocesstellyslipModel createpayment);
}
