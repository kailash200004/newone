package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.OperationAndTransportCostDao;
import com.jci.model.OperationAndTransportCostModel;
import com.jci.service_phase2.OperationAndTransportCostService;

@Service
public class OperationAndTransportCostServiceImpl implements OperationAndTransportCostService {

	@Autowired
	OperationAndTransportCostDao operationCostDao;
	
	@Override
	public void create(OperationAndTransportCostModel operationcostmodel) {
		// TODO Auto-generated method stub
		operationCostDao.create(operationcostmodel);
	}

	@Override
	public List<OperationAndTransportCostModel> getAlllist() {
		// TODO Auto-generated method stub
		return operationCostDao.getAlllist();
	}

	
}
