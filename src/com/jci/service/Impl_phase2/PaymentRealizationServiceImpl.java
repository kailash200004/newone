package com.jci.service.Impl_phase2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.PaymentRealizationDao;
import com.jci.service_phase2.PaymentRealizationService;

@Service
public class PaymentRealizationServiceImpl implements PaymentRealizationService {
	
	@Autowired
	PaymentRealizationDao paymentRealizationDao;

	@Override
	public void create(String fileName) {
		paymentRealizationDao.create(fileName);
		
	}

}
