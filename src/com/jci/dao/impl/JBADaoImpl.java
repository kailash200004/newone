package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.JbaDao;
import com.jci.model.JbaModel;


@Transactional
@Repository
public class JBADaoImpl implements JbaDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(JbaModel jbaP) {
		currentSession().saveOrUpdate(jbaP);;

	}

	@Override
	public void update(JbaModel jbaP) {
		currentSession().update(jbaP);

	}
	@Override
	public JbaModel edit(int id) {
		return find(id);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "Delete from dbo.jcijba where jbaid = '"+id+"' " ;
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}



	@Override
	public JbaModel find(int id) {
		return (JbaModel) currentSession().get(JbaModel.class, id);
	}

	@Override
	public List<JbaModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JbaModel.class);
		List<JbaModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(JbaModel jbaP) {
		this.sessionFactory.getCurrentSession().save(jbaP);
		return false;
	}

	@Override
	public List <String> GetDayCountofJBA(String jbaId) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		int a=0;

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		System.out.println("id from JBA DAO Impl is"+jbaId);
		Query query = session.createSQLQuery("{CALL GetDatediffWithCurrentDt(:PID)}");
		query.setParameter("PID", jbaId);

		List<String> results = query.list();
		return results;


	}

	@Override
	public List<String> findGradeOnJuteVariety(String jvariety) {
		List<String> result = new ArrayList<>();
		int count=0;

		String querystr = "SELECT grade FROM jcijutevariety where  jutevariety like '"+ jvariety+"%'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}





}
