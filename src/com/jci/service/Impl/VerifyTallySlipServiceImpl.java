package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.VerificationTallySlipDao;
import com.jci.model.VerifyTallySlip;
import com.jci.service.VerifyTallySlipService;

@Service
public class VerifyTallySlipServiceImpl implements VerifyTallySlipService {

	@Autowired
	VerificationTallySlipDao VerificationTallySlipDao;

	@Override
	public void create(VerifyTallySlip VerifyTallySlip) {
		VerificationTallySlipDao.create(VerifyTallySlip);
	}

	@Override
	public void update(VerifyTallySlip VerifyTallySlip) {
		VerificationTallySlipDao.update(VerifyTallySlip);
	}

	@Override
	public VerifyTallySlip edit(int id) {
		return VerificationTallySlipDao.edit(id);
	}

	@Override
	public void delete(int id) {
		VerificationTallySlipDao.delete(id);
	}

	@Override
	public VerifyTallySlip find(int id) {
		return VerificationTallySlipDao.find(id);
	}

	@Override
	public List<VerifyTallySlip> getAll(String status) {
		return VerificationTallySlipDao.getAll(status);
	}

	@Override
	public boolean submitform(VerifyTallySlip VerifyTallySlip) {
		return VerificationTallySlipDao.submitform(VerifyTallySlip);
	}


	/*
	 * @Override public VerifyTallySlip findByTally(String tallyslipno) { return
	 * VerificationTallySlipDao.findByTally(tallyslipno); }
	 */

	@Override
	public String GettransectionDetails(String tallyNo,String region) {

		return VerificationTallySlipDao.GettransectionDetails(tallyNo,region);
	}

	@Override
	public boolean updatebyTally(String status, int verified, String tallyno) {

		return VerificationTallySlipDao.updatebyTally(status, verified, tallyno);
	}



}
