package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.EntryDerivativePrice;

public interface EntryDerivativePriceDao2 {
	public void create(EntryDerivativePrice edp);
	public void update(EntryDerivativePrice edp);
	public EntryDerivativePrice edit(int id);

	/* comment for check */
	public void delete(int id);
	public EntryDerivativePrice findById(int id);
	public List <EntryDerivativePrice> getAllEDP();
	
}
