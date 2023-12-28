package com.jci.service;

import java.util.List;

import com.jci.model.DistrictModel;

public interface DistrictService {
	public void create(DistrictModel distric);
	public void update(DistrictModel distric);
	public DistrictModel edit(int id);
	public void delete(int id);
	public DistrictModel find(int id);
	public List <DistrictModel> getAll();
	public boolean submitform(DistrictModel off);
	public List <String> getAllFilledPosition(String id);
	public List <String> getSpecificDistricts(String state, String crop_year, String delivery_type);
	public List<String> findByDistrictIds(String dids);
	public List<String> getDistrictCodeByDistrictIds(String dids);
}
