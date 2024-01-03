package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.OperationAndTransportCostModel;

public interface OperationAndTransportCostDao {

	void create(OperationAndTransportCostModel operationcostmodel);

	List<OperationAndTransportCostModel> getAlllist();

}
