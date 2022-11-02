package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BatchDao;
import com.jci.model.BatchIdentificationModel;


@Transactional
@Repository
public class BatchDaoImpl implements BatchDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BatchIdentificationModel batch) {
		currentSession().save(batch);
	}

	@Override
	public void update(BatchIdentificationModel batch) {
		currentSession().update(batch);
	}

	@Override
	public BatchIdentificationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		BatchIdentificationModel rulingMarket = new BatchIdentificationModel();
		String hql = "Delete from dbo.jcirulingmarket where jcirulingmarketid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public BatchIdentificationModel find(int id) {
		return (BatchIdentificationModel) currentSession().get(BatchIdentificationModel.class, id);
	}

	@Override
	public List<BatchIdentificationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BatchIdentificationModel.class);
		List<BatchIdentificationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(BatchIdentificationModel batch) {
		this.sessionFactory.getCurrentSession().save(batch);
		return false;
	}

	@Override
	public List<String> GetDpcNamefromId(int dpcid) {
		List<String> result = new ArrayList<>();
		int count=0;

		//String querystr = "SELECT grade FROM jcijutevariety where  jutevariety like '"+ jvariety+"%'";
		String querystr = "select centername from dbo.jcipurchasecenter where pcid = '"+dpcid+"' ";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}
}
