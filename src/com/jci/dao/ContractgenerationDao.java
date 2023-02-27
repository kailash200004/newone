package com.jci.dao;

import java.util.List;

import com.jci.model.Contractgeneration;
import com.jci.model.ContractgenerationMillWise;

public interface ContractgenerationDao {

	public void create(Contractgeneration contractgeneration);

	public void update(Contractgeneration contractgeneration);

	public Contractgeneration edit(int id);

	public void delete(int id);

	public Contractgeneration find(int id);

	public List<Contractgeneration> getAll();

}
