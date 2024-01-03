package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.FactorssInvolvedCommercial;

public interface FactorssInvolvedCommercialDao {

	void create(List<FactorssInvolvedCommercial> allList);

	public List<FactorssInvolvedCommercial> getAll();

}
