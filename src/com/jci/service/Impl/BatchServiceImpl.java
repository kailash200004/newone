package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.BatchDao;
import com.jci.model.BatchIdentificationModel;
import com.jci.service.BatchIdentificationService;

@Service
public class BatchServiceImpl implements BatchIdentificationService {

	@Autowired
	BatchDao batchdao;

	@Override
	public void create(BatchIdentificationModel batch) {
		batchdao.create(batch);
	}

	@Override
	public void update(BatchIdentificationModel batch) {
		batchdao.update(batch);
	}

	@Override
	public BatchIdentificationModel edit(int id) {
		return batchdao.edit(id);
	}

	@Override
	public void delete(int id) {
		batchdao.delete(id);
	}

	@Override
	public BatchIdentificationModel find(int id) {
		return batchdao.find(id);
	}

	@Override
	public List<BatchIdentificationModel> getAll() {
		return batchdao.getAll();
	}

	@Override
	public boolean submitform(BatchIdentificationModel batch) {
		return batchdao.submitform(batch);
	}

	@Override
	public List<String> GetDpcNamefromId(int dpcid) {
		// TODO Auto-generated method stub
		return batchdao.GetDpcNamefromId(dpcid);
	}

}
