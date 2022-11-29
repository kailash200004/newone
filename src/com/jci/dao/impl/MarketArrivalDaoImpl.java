package com.jci.dao.impl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.MarketArrivalDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.MarketArrivalModel;


@Transactional
@Repository
public class MarketArrivalDaoImpl implements MarketArrivalDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(MarketArrivalModel marketArrival) {
		currentSession().save(marketArrival);

	}

	@Override
	public void update(MarketArrivalModel marketArrival) {
		currentSession().update(marketArrival);

	}

	@Override
	public MarketArrivalModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public MarketArrivalModel find(int id) {
		return (MarketArrivalModel) currentSession().get(MarketArrivalModel.class, id);
	}

	@Override
	public List<MarketArrivalModel> getAlldata() {
		List<MarketArrivalModel> ll = new ArrayList<>();
		List<Object[]> rows = new ArrayList<>();
		MarketArrivalModel maketarrival = new MarketArrivalModel();
		String querystr = "Select a.*, b.centername from jcimra a left Join jcipurchasecenter b on a.dpc_code = b.CENTER_CODE and a.region_id= b.rocode";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		rows = query.list();
		//System.out.println(rows);
		for(Object[] row: rows) {
			int id= (int) row[0];
			Date datearrival= (Date) row[2];
			String jutevariety= (String) row[3];
			String cropyr= (String) row[4];
			String arrivedqty= (String) row[5];
			String max= (String) row[6];
			String min= (String) row[7];
			String ro= (String)row[8];
			String centername= (String) row[29];
			/*
			 * double grade1= (double)row[9]; double grade2= (double)row[10]; double grade3=
			 * (double)row[11]; double grade4= (double)row[12]; double grade5=
			 * (double)row[13]; double grade6= (double)row[14]; double grade7=
			 * (double)row[15]; double grade8= (double)row[16];
			 */
			maketarrival.setMrarefid(id);
			maketarrival.setDatearrival(datearrival);
			maketarrival.setJutevariety(jutevariety);
			maketarrival.setCropyr(cropyr);
			maketarrival.setArrivedqty(arrivedqty);
			maketarrival.setMaxmois(max);
			maketarrival.setMixmois(min);
			maketarrival.setDpcnames(centername);
			maketarrival.setRegion_id(ro);
			//maketarrival.setGrade1(grade1);
			ll.add(maketarrival);	
		}
		System.out.println("=========== "+l1);
		return ll;
	}

	@Override
	public boolean submitform(MarketArrivalModel marketArrival) {
		this.sessionFactory.getCurrentSession().save(marketArrival);
		return false;
	}

}
