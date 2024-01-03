package com.jci.service_phase2;

import java.util.List;

import com.jci.model.OperationAndTransportCostModel;

public interface OperationAndTransportCostService {

	void create(OperationAndTransportCostModel operationcostmodel);

	List<OperationAndTransportCostModel> getAlllist();

}
