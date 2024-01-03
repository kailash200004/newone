package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.OperationCostDao;
import com.jci.model.OperationCostModel;

@Transactional
@Repository
public class OperationCostDaoImpl implements OperationCostDao{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<OperationCostModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(OperationCostModel.class);
		List<OperationCostModel> ll=c.list();
		return ll;
	}

}
