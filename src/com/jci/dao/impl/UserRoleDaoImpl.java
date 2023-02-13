package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
