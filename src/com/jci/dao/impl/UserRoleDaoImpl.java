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

import com.jci.dao.UserRoleDao;
import com.jci.model.PincodeModel;
import com.jci.model.UserRoleModel;
@Transactional
@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(UserRoleModel userrole) {
		currentSession().save(userrole);
	}

	@Override
	public List<UserRoleModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(UserRoleModel.class);
		List<UserRoleModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean validateRole(String role) {
		List<Integer> result = new ArrayList<>();
		String querystr = "  select * from jciuserrole where role_name ='"+role+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if(isPresent) {
			return true;
		}else {
			return false;
		}
	}
}
