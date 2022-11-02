package com.jci.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.MarketArrivalDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.MarketArrivalModel;


@Transactional
@Repository
public class MarketArrivalDaoImpl implements MarketArrivalDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(MarketArrivalModel marketArrival) {
		currentSession().save(marketArrival);

	}

	@Override
	public void update(MarketArrivalModel marketArrival) {
		currentSession().update(marketArrival);

	}

	@Override
	public MarketArrivalModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public MarketArrivalModel find(int id) {
		return (MarketArrivalModel) currentSession().get(MarketArrivalModel.class, id);
	}

	@Override
	public List<MarketArrivalModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(MarketArrivalModel.class);
		List<MarketArrivalModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(MarketArrivalModel marketArrival) {
		this.sessionFactory.getCurrentSession().save(marketArrival);
		return false;
	}

}
