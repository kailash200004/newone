package com.jci.dao.impl_phase2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.OperationAndTransportCostDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.OperationAndTransportCostModel;

@Transactional
@Repository
public class OperationAndTransportCostDaoImpl implements OperationAndTransportCostDao{


	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(OperationAndTransportCostModel operationcostmodel) {
		// TODO Auto-generated method stub
		currentSession().save(operationcostmodel);
	}
	@Override
	public List<OperationAndTransportCostModel> getAlllist() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(OperationAndTransportCostModel.class);
		List<OperationAndTransportCostModel> ll=c.list();
		return ll;
	}
}
