package com.jci.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.jci.dao.VerificationTallySlipDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.VerifyTallySlip;

@Transactional
@Repository
public class VerificationTallySlipDaoImpl implements VerificationTallySlipDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(VerifyTallySlip verifyTallySlip) {
		currentSession().save(verifyTallySlip);
	}

	@Override
	public void update(VerifyTallySlip verifyTallySlip) {
		currentSession().update(verifyTallySlip);
	}

	@Override
	public VerifyTallySlip edit(int id) {
		return find(id);
	}


	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.verificationtallyslip where tallyslipno= '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public VerifyTallySlip find(int id) {
		return (VerifyTallySlip) currentSession().get(VerifyTallySlip.class, id);
	}

	/*
	 * @Override public VerifyTallySlip findByTally(String tallyslipno) { return
	 * (VerifyTallySlip) currentSession().get(VerifyTallySlip.class, tallyslipno); }
	 */

	@Override
	public List<VerifyTallySlip> getAll(String status) {
	List<VerifyTallySlip> r = new ArrayList<>();
	List<Object[]> result = new ArrayList<>();
	String querystr = "Select * from verificationtallyslip where status='"+status+"'";

	Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	SQLQuery query = session.createSQLQuery(querystr);
	result = query.list();
	if(result.size()>=1)
	{
	//Object[] row = result.get(0);
	for(Object[] row : result)
	{
		VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
		Date date = (Date)row[3];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(date);
		//System.out.println(dateString);
        try {
			date       = format.parse ( dateString );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyTallySlip.setDop(dateString);
		verifyTallySlip.setRateslipno((int)row[4]);
		verifyTallySlip.setBinno((int)row[5]);
		verifyTallySlip.setNetquantity(((BigDecimal)row[7]).doubleValue());
		verifyTallySlip.setGarsatrate(((BigDecimal)row[8]).doubleValue());
		verifyTallySlip.setAmountpayable(((BigDecimal)row[9]).doubleValue());
		verifyTallySlip.setJutevariety((String)row[6]);
		verifyTallySlip.setGrossqty(((BigDecimal)row[67]).doubleValue());
		verifyTallySlip.setFarmerRegNo((String)row[1]);
	//	verifyTallySlip.setTallySlipImg((String)row[9]);
		verifyTallySlip.setTallyNo((String)row[2]);
		verifyTallySlip.setPlaceOfPurchase((String)row[11]);
		verifyTallySlip.setErrors((String)row[65]);
		verifyTallySlip.setTallyid((int)row[0]);
		r.add(verifyTallySlip);
	}

       	return 	r;
	}
	else
	{
		return null;
	}
	}

	@Override
	public boolean submitform(VerifyTallySlip verifyTallySlip) {
		this.sessionFactory.getCurrentSession().save(verifyTallySlip);
		return false;
	}

	@Override
	public String GettransectionDetails(String tallyNo) {

		// System.out.println("############"+ tallyNo);
		List<VerifyTallySlip> r = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		String querystr = "Select  datepurchase, rateslipno, binno, netquantity, grasatrate, amountpayable, jutevariety, grossquantity, farmerregno, slip_image, tallyslipno,placeofpurchase from jciprocurement where tallyslipno='"+tallyNo+"' and is_varified = 0 and status = 'ROV'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		if(result.size()>=1)
		{
		Object[] row = result.get(0);


			VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
			Date date = (Date)row[0];
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = format.format(date);
			System.out.println(dateString);
            try {
				date       = format.parse ( dateString );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			verifyTallySlip.setDop(dateString);
			verifyTallySlip.setRateslipno((int)row[1]);
			verifyTallySlip.setBinno((int)row[2]);
			verifyTallySlip.setNetquantity(((BigDecimal)row[3]).doubleValue());
			verifyTallySlip.setGarsatrate(((BigDecimal)row[4]).doubleValue());
			verifyTallySlip.setAmountpayable(((BigDecimal)row[5]).doubleValue());
			verifyTallySlip.setJutevariety((String)row[6]);
			verifyTallySlip.setGrossqty(((BigDecimal)row[7]).doubleValue());
			verifyTallySlip.setFarmerRegNo((String)row[8]);
			verifyTallySlip.setTallySlipImg((String)row[9]);
			verifyTallySlip.setTallyNo((String)row[10]);
			verifyTallySlip.setPlaceOfPurchase((String)row[11]);
			//System.out.println("================>>>>>>>>>>>result  "+result.toString());
			//r.add(verifyTallySlip);
           Gson gson = new Gson();
           gson.toJson(verifyTallySlip);
           System.out.println("================>>>>>>>>>>>result  "+gson.toJson(verifyTallySlip));
		return 	gson.toJson(verifyTallySlip);
		}
		else
		{
			return null;
		}
	}



	@Override
	public boolean updatebyTally(String statuss, int verified, String tallyno) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update VerifyTallySlip set status ='"+statuss+"', is_varified ="+verified+" where tallyNo='"+tallyno+"'");
			int status=q.executeUpdate();
			if(status>=1) {
				returnStatus =true;
				return returnStatus;
			} else {
				returnStatus =false;
				return returnStatus;
			}
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return returnStatus;
	}


}
