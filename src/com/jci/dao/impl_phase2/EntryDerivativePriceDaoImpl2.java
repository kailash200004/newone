package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.EntryDerivativePriceDao2;
import com.jci.model.EntryDerivativePrice;

@Transactional
@Repository
public class EntryDerivativePriceDaoImpl2 implements EntryDerivativePriceDao2 {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryDerivativePrice edp) {
		currentSession().save(edp);

	}

	@Override
	public void update(EntryDerivativePrice edp) {

		currentSession().saveOrUpdate(edp);
	}

	@Override
	public EntryDerivativePrice edit(int id) {

		return (EntryDerivativePrice) currentSession().get(EntryDerivativePrice.class, id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcientry_derivative_price where der_id= '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public EntryDerivativePrice findById(int id) {
		return (EntryDerivativePrice) currentSession().get(EntryDerivativePrice.class, id);

	}

	@Override
	public List<EntryDerivativePrice> getAllEDP() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(EntryDerivativePrice.class).addOrder(Order.desc("creation_date"));
      List<EntryDerivativePrice> ll = c.list();
		return ll;
	}

}
