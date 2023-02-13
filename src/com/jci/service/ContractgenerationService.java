package com.jci.service;

import java.util.List;

import com.jci.model.Contractgeneration;

public interface ContractgenerationService {
	public void create(Contractgeneration contractgeneration);

	public void update(Contractgeneration contractgeneration);

	public Contractgeneration edit(int contract_id);

	public void delete(int contract_id);

	public Contractgeneration find(int contract_id);

	public List<Contractgeneration> getAll();
}
