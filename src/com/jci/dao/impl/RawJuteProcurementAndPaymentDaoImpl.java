package com.jci.dao.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

import com.jci.dao.RawJuteProcurementAndPaymentDao;
import com.jci.model.RawJuteProcurementAndPayment;

@Transactional
@Repository
public class RawJuteProcurementAndPaymentDaoImpl implements RawJuteProcurementAndPaymentDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		currentSession().saveOrUpdate(rawJuteProcurementAndPayment);
	}

	@Override
	public void update(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		currentSession().update(rawJuteProcurementAndPayment);
	}

	@Override
	public RawJuteProcurementAndPayment edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jciprocurement where ptsid = '"+id+"' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RawJuteProcurementAndPayment find(int id) {
		return (RawJuteProcurementAndPayment) currentSession().get(RawJuteProcurementAndPayment.class, id);
	}

	@Override
	public List<RawJuteProcurementAndPayment> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RawJuteProcurementAndPayment.class);
		List<RawJuteProcurementAndPayment> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		this.sessionFactory.getCurrentSession().save(rawJuteProcurementAndPayment);
		return false;
	}

	@Override
	public List<String> farmerNoVarification(String farmerNo) {
		List<String> result = new ArrayList<>();
		String querystr = "select F_NAME, F_MOBILE, F_AC_NO  from jcirmt where F_REG_NO ='"+farmerNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> data = query.list();
		for(Object[] cart : data) {
			//result.add(cart[0].toString()+"-"+cart[1].toString());
			result.add(cart[0].toString()+"-"+cart[1].toString()+"-"+cart[2].toString());
		}
		return result;
	}

	@Override
	public List<String> allDpcList() {
		List<String> result = new ArrayList<>();
		String querystr = "Select * from jcipurchasecenter";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			//System.out.println("CENTER_CODE ==="+ row[1].toString() + "centername==="+row[4].toString());
			result.add(row[1].toString()+"-"+row[4].toString());
		}
		return result;
	}
	@Override
	public List<String> findJuteOnBasis(int msp_no) {
		List<String> result = new ArrayList<>();
		String querystr = "SELECT distinct(jutevariety) FROM jcijutevariety where basis ='"+msp_no+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}

	@Override
	public List<String> findGradeOnJuteVariety(String variety, int basis_no) {
		List<String> result = new ArrayList<>();
		int count=0;

		String querystr = "SELECT grade FROM jcijutevariety where basis ='"+basis_no+"' and jutevariety like '"+ variety+"%'";

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}
	@Override
	public List<String> findGradePriceJuteVariety(String variety, int basis_no, String cropyr, String dpcid) {



		String querystr="";
		List<String> result = new ArrayList<>();
		int count=0;

		if(basis_no==1) {
		 querystr =  "SELECT grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%'";
		}
		else if(basis_no==2) {
			 querystr = "SELECT grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%' and dpc like '%"+dpcid+"%'";
			}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
	//	System.out.println("result========>>>>>>"+query.list());
	//	 count = query.list().size();

		return result;
	}

	@Override
	public List<String> getfarmerno() {
		String queryStr="";
		List<String> result = new ArrayList<>();
		queryStr= "select DISTINCT F_REG_NO from jcirmt where IS_VERIFIED=1";
		Session session= sessionFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		SQLQuery query= session.createSQLQuery(queryStr);
		result = query.list();
	//	System.out.println("result========>>>>>>"+query.list());
		return result;
	}


	@Override
	public List<RawJuteProcurementAndPayment> farmerDetailsList() {

		List<RawJuteProcurementAndPayment> list =new ArrayList<>();

	String	queryStr="select farmerregno,datepurchase,basis,cropyr,placeofpurchase,rateslipno,binno,jutevariety, grossquantity,deductionquantity,grasatrate,amountpayable ,ptsid,tallyslipno, tallySlipImg from jciprocurement where farmerregno Not in (select farmerregno from verificationtallyslip)";
	List<RawJuteProcurementAndPayment> result = new ArrayList<>();
	List<Object[]> res = new ArrayList<>();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(queryStr);

		res = query.list();
		//final List<MyObject> list = new LinkedList<>();
		for( Object[] o : res) {
			RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
			String farmer = (String)o[0];
			Date datepurchase = (Date)o[1];
			String basis = (String)o[2];
			String cropyr = (String)o[3];
			String placeofpurchase = (String)o[4];
			int rateslipno = (int)o[5];
			int binno = (int)o[6];
			String jutevariety = (String)o[7];
			BigDecimal grossquantity = (BigDecimal)o[8];
			//System.out.println("grossquantity  ====== "+grossquantity);
			BigDecimal deductionquantity = (BigDecimal)o[9];
			BigDecimal grasatrate = (BigDecimal)o[10];
			BigDecimal amountpayable = (BigDecimal)o[11];
			int ptsid = (int)o[12];
			String tallyslip =  (String)o[13];
			raw.setFarmerregno(farmer);
			raw.setDatepurchase(datepurchase);
			raw.setBasis(basis);
			raw.setCropyr(cropyr);
			raw.setPlaceofpurchase(placeofpurchase);
			raw.setRateslipno(rateslipno);
			raw.setBinno(binno);
			raw.setJutevariety(jutevariety);
			raw.setGrossquantity(grossquantity.doubleValue());
			raw.setDeductionquantity(deductionquantity.doubleValue());
			raw.setGrasatrate(grasatrate.doubleValue());
			raw.setAmountpayable(amountpayable.doubleValue());
			raw.setPtsid(ptsid);
			raw.setTallyslipno(tallyslip);
			result.add(raw);
			//System.out.println("farmer  ====== "+farmer);
		}

		  return result;

	}

	@Override
	public boolean updateProcurement(String statuss, int verified,String tallyno) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update RawJuteProcurementAndPayment set status ='"+statuss+"', is_varified ="+verified+" where tallyslipno='"+tallyno+"'");
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

	@Override
	public boolean updateProcurementerror(String statuss, int verified,String tallyno,String error) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update  RawJuteProcurementAndPayment set status ='"+statuss+"', is_varified ="+verified+" , reason = '"+error+"' where tallyslipno='"+tallyno+"'");
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

	@Override
	public RawJuteProcurementAndPayment findbyTally(String tallyno) {
		String	queryStr="select farmerregno,datepurchase,basis,cropyr,placeofpurchase,rateslipno,binno,jutevariety, grossquantity,deductionquantity,grasatrate,amountpayable ,ptsid,tallyslipno, tallySlipImg from jciprocurement where tallyslipno ='"+tallyno+"'";
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
			Object[] o = res.get(0);

				RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
				String farmer = (String)o[0];
				Date datepurchase = (Date)o[1];
				String basis = (String)o[2];
				String cropyr = (String)o[3];
				String placeofpurchase = (String)o[4];
				int rateslipno = (int)o[5];
				int binno = (int)o[6];
				String jutevariety = (String)o[7];
				BigDecimal grossquantity = (BigDecimal)o[8];
				//System.out.println("grossquantity  ====== "+grossquantity);
				BigDecimal deductionquantity = (BigDecimal)o[9];
				BigDecimal grasatrate = (BigDecimal)o[10];
				BigDecimal amountpayable = (BigDecimal)o[11];
				int ptsid = (int)o[12];
				String tallyslip =  (String)o[13];
				raw.setFarmerregno(farmer);
				raw.setDatepurchase(datepurchase);
				raw.setBasis(basis);
				raw.setCropyr(cropyr);
				raw.setPlaceofpurchase(placeofpurchase);
				raw.setRateslipno(rateslipno);
				raw.setBinno(binno);
				raw.setJutevariety(jutevariety);
				raw.setGrossquantity(grossquantity.doubleValue());
				raw.setDeductionquantity(deductionquantity.doubleValue());
				raw.setGrasatrate(grasatrate.doubleValue());
				raw.setAmountpayable(amountpayable.doubleValue());
				raw.setPtsid(ptsid);
				raw.setTallyslipno(tallyslip);
			//	result.add(raw);
				//System.out.println("farmer  ====== "+farmer);

			  return raw;
	}

	@Override
	public List<RawJuteProcurementAndPayment> jutelistbystatus(String status) {

		String	queryStr="select farmerregno,datepurchase,basis,cropyr,placeofpurchase,rateslipno,binno,jutevariety, grossquantity,deductionquantity,grasatrate,amountpayable ,ptsid,tallyslipno, tallySlipImg from jciprocurement where status ='"+status+"'";
		List<RawJuteProcurementAndPayment> result = new ArrayList<>();
		List<Object[]> res = new ArrayList<>();

			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(queryStr);
	        res = query.list();
			for(Object[] o : res) {

				RawJuteProcurementAndPayment raw = new RawJuteProcurementAndPayment();
				String farmer = (String)o[0];
				Date datepurchase = (Date)o[1];
				String basis = (String)o[2];
				String cropyr = (String)o[3];
				String placeofpurchase = (String)o[4];
				int rateslipno = (int)o[5];
				int binno = (int)o[6];
				String jutevariety = (String)o[7];
				BigDecimal grossquantity = (BigDecimal)o[8];
				//System.out.println("grossquantity  ====== "+grossquantity);
				BigDecimal deductionquantity = (BigDecimal)o[9];
				BigDecimal grasatrate = (BigDecimal)o[10];
				BigDecimal amountpayable = (BigDecimal)o[11];
				int ptsid = (int)o[12];
				String tallyslip =  (String)o[13];
				raw.setFarmerregno(farmer);
				raw.setDatepurchase(datepurchase);
				raw.setBasis(basis);
				raw.setCropyr(cropyr);
				raw.setPlaceofpurchase(placeofpurchase);
				raw.setRateslipno(rateslipno);
				raw.setBinno(binno);
				raw.setJutevariety(jutevariety);
				raw.setGrossquantity(grossquantity.doubleValue());
				raw.setDeductionquantity(deductionquantity.doubleValue());
				raw.setGrasatrate(grasatrate.doubleValue());
				raw.setAmountpayable(amountpayable.doubleValue());
				raw.setPtsid(ptsid);
				raw.setTallyslipno(tallyslip);
				result.add(raw);
				//System.out.println("farmer  ====== "+farmer);
			}

			  return result;
	}

	@Override
	public boolean validateTally(String tally, String ro) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciprocurement where tallyslipno ='"+tally+"' and regionId='"+ro+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//System.out.println("you are in DAO layer");
		boolean tallyMatched = rows.isEmpty();		// returns true if no tally number is found in db
		if(tallyMatched) {
			return true;
		}else {
			return false;
		}
		
	}







}
