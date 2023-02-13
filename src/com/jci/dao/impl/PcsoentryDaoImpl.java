package com.jci.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;

@Transactional
@Repository
public class PcsoentryDaoImpl implements PcsoentryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		currentSession().save(entryofpcso);
	}

}
