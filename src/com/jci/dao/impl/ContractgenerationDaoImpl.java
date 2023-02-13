package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ContractgenerationDao;
import com.jci.model.Contractgeneration;

@Transactional
@Repository
public class ContractgenerationDaoImpl implements ContractgenerationDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Contractgeneration contractgeneration) {

		currentSession().save(contractgeneration);
	}

	@Override
	public void update(Contractgeneration contractgeneration) {

		currentSession().update(contractgeneration);
	}

	@Override
	public Contractgeneration edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {

		String hql = "Delete from dbo.jcicontractgeneration where contract_id = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public Contractgeneration find(int id) {

		return (Contractgeneration) currentSession().get(Contractgeneration.class, id);
	}

	@Override
	public List<Contractgeneration> getAll() {

		List<Contractgeneration> ll;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Contractgeneration.class);
		ll = c.list();
		return ll;
	}

}
