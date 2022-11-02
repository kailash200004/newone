package com.jci.dao;

import java.util.List;

import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;

public interface FarmerRegDao {
	public void create(FarmerRegModel FarmerRegModel);
	public void update(FarmerRegModel FarmerRegModel);
	public FarmerRegModel edit(int id);
	public void delete(int id);
	public FarmerRegModel find(int id);
	public List <FarmerRegModel> getAll();
	public boolean submitform(FarmerRegModel FarmerRegModel);
	public boolean validateMobile(String mobileNo);
	public List<FarmerRegModelDTO> verificationStatus();
	public boolean updateVerificationStatus(int id);
	boolean validateAccount(String accountNo);
	boolean validateAdhar(String aadharNo);
}