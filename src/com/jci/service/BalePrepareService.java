package com.jci.service;
import java.util.List;

import com.jci.model.BalePreparation;

public interface BalePrepareService {
	public void create(BalePreparation BalePreparation);
	public void update(BalePreparation BalePreparation);
	public BalePreparation edit(int id);
	public void delete(int id);
	public BalePreparation find(int id);
	public List<BalePreparation> getAll();
	public boolean submitform(BalePreparation Zone);
}
