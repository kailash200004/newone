package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.OperationCostDao;
import com.jci.model.OperationCostModel;
import com.jci.service_phase2.OperationCostService;

@Service
public class OperationCostServiceImpl implements OperationCostService {

	@Autowired
	OperationCostDao operationcostDao;
	
	@Override
	public List<OperationCostModel> getAll() {
		// TODO Auto-generated method stub
		return operationcostDao.getAll();
	}

}
