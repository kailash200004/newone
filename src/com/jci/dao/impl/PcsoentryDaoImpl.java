package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;

@Transactional
@Repository
public class PcsoentryDaoImpl implements PcsoentryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		currentSession().save(entryofpcso);
	}

	@Override
	public List<EntryofpcsoModel> getAlldata() {
		// TODO Auto-generated method stub
		List<EntryofpcsoModel> ll = new ArrayList<>();
		List<Object[]> rows = new ArrayList<>();
		String querystr = "select child_id,client_unit_code,unit_name from jcimilldetailchild";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		rows = query.list();
		System.out.println(rows);
		for(Object[] row: rows) {
			int childid= (int) row[0];
			String millcode= (String) row[1];
			String millname= (String) row[2];
			EntryofpcsoModel entryofpcsoModel = new EntryofpcsoModel();
			entryofpcsoModel.setPcsorefid(childid);
			entryofpcsoModel.setMill_code(millcode);
			entryofpcsoModel.setMill_name(millname);
			ll.add(entryofpcsoModel);
		}
		System.out.println("=========== "+ll.toString());
		return ll;
	}

}
