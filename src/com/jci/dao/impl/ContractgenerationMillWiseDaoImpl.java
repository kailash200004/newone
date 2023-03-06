package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ContractgenerationMillWiseDao;
import com.jci.model.ContractgenerationMillWise;


@Transactional
@Repository
public class ContractgenerationMillWiseDaoImpl implements ContractgenerationMillWiseDao{

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void create(ContractgenerationMillWise contractgeneration) {
		// TODO Auto-generated method stub

		currentSession().save(contractgeneration);
	}

	@Override
	public void update(ContractgenerationMillWise contractgeneration) {
		// TODO Auto-generated method stub
		currentSession().update(contractgeneration);
	}

	@Override
	public ContractgenerationMillWise edit(int id) {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContractgenerationMillWise find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractgenerationMillWise> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
