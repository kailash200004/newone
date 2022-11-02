package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BalePrepareDao;
import com.jci.model.BalePreparation;
import com.jci.model.FarmerRegistrationModel;

@Transactional
@Repository
public class BalePrepareDaoImpl implements BalePrepareDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BalePreparation BalePreparation) {
		currentSession().save(BalePreparation);
	}

	@Override
	public void update(BalePreparation BalePreparation) {
		currentSession().update(BalePreparation);
	}

	@Override
	public BalePreparation edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public BalePreparation find(int id) {
		return (BalePreparation) currentSession().get(BalePreparation.class, id);
	}

	@Override
	public List<BalePreparation> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BalePreparation.class);
		List<BalePreparation> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(BalePreparation BalePreparation) {
		this.sessionFactory.getCurrentSession().save(BalePreparation);
		return false;
	}

}
