package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.DistributionoftallyslipDao;
import com.jci.model.DistributionoftallyslipModel;

@Transactional
@Repository

public class DistributionoftallyslipDaoImpl implements DistributionoftallyslipDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(DistributionoftallyslipModel distributionoftallyslipModel) {
		currentSession().saveOrUpdate(distributionoftallyslipModel);

	}

	@Override
	public void update(DistributionoftallyslipModel distributionoftallyslipModel) {
		currentSession().save(distributionoftallyslipModel);

	}

	@Override
	public DistributionoftallyslipModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcislip where refid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public DistributionoftallyslipModel find(int id) {
		return (DistributionoftallyslipModel) currentSession().get(DistributionoftallyslipModel.class, id);
	}

	@Override
	public List<DistributionoftallyslipModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DistributionoftallyslipModel.class);
		List<DistributionoftallyslipModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(DistributionoftallyslipModel distributionoftallyslipModel) {
		this.sessionFactory.getCurrentSession().save(distributionoftallyslipModel);
		return false;
	}

}
