package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.EntryDerivativePriceDao2;
import com.jci.dao.impl_phase2.EntryDerivativePriceDaoImpl2;
import com.jci.model.EntryDerivativePrice;
import com.jci.service_phase2.EntryDerivativePriceService2;


@Service
public class EntryDerivativePriceServiceImpl2 implements EntryDerivativePriceService2
{
   
	@Autowired
	EntryDerivativePriceDao2 entryDerivativePriceDao2;
	
	@Override
	public void create(EntryDerivativePrice edprice) {
		this.entryDerivativePriceDao2.create(edprice);

	}

	@Override
	public void update(EntryDerivativePrice edprice) {
		this.entryDerivativePriceDao2.update(edprice);
	}

	@Override
	public void delete(int id) {
		this.entryDerivativePriceDao2.delete(id);

	}

	@Override
	public EntryDerivativePrice findEDPBYId(int id) {
	
		return this.entryDerivativePriceDao2.findById(id);
	}

	@Override
	public List<EntryDerivativePrice> getAllEDP() {
		return this.entryDerivativePriceDao2.getAllEDP();
	}

}
