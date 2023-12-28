package com.jci.dao.impl_phase2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jci.dao_phase2.PaymentRealizationDao;

@Repository
public class PaymentRealizationDaoImpl implements PaymentRealizationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void create(String fileName) {
		 String sqlString = "insert into UploadPaymentRealization (fileName) values (' " + fileName +"')";
		 
		 currentSession().createSQLQuery(sqlString).executeUpdate();
		 
	}

	
}
