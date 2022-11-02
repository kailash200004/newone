package com.jci.service;

import java.util.List;

import com.jci.model.BatchIdentificationModel;

public interface BatchIdentificationService {
	public void create(BatchIdentificationModel batch);
	public void update(BatchIdentificationModel batch);
	public BatchIdentificationModel edit(int id);
	public void delete(int id);
	public BatchIdentificationModel find(int id);
	public List<BatchIdentificationModel> getAll();
	public boolean submitform(BatchIdentificationModel batch);

	public List<String> GetDpcNamefromId(int dpcid);
}
