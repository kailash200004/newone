package com.jci.dao.impl;

import java.util.ArrayList;
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
 
import com.jci.dao.FarmerRegDao;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;

@Transactional
@Repository
public class FarmerRegDaoImpl implements FarmerRegDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		 FarmerRegDaoImpl fr = new FarmerRegDaoImpl();
		 fr.findRegno("05","0212");
	}
	
	
	@Override
	public void create(FarmerRegModel farmerRegModel) {
		currentSession().saveOrUpdate(farmerRegModel);
	}

	@Override
	public void update(FarmerRegModel farmerRegModel) {
		currentSession().update(farmerRegModel);
	}

	@Override
	public FarmerRegModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegModel farmerRegModel = new FarmerRegModel();
		String hql = "Delete from dbo.jcirmt where F_ID = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public FarmerRegModel find(int id) {
		return (FarmerRegModel) currentSession().get(FarmerRegModel.class, id);
	}

	@Override
	public List<FarmerRegModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(FarmerRegModel.class);
		List<FarmerRegModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(FarmerRegModel farmerRegModel) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(farmerRegModel);
		return false;
	}

	@Override
	public boolean validateMobile(String mobileNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcirmt where F_MOBILE ='"+mobileNo+"'";
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


	@Override
	public List <FarmerRegModelDTO> verificationStatus() {
		List<Integer> result = new ArrayList<>();
		String querystr = "Select a.*, b.verficationid, b.regno, b.ifsccode, b.accountno, b.farmername, b.address, b.status, b.verificationdate, st.state_name from jcirmt a left Join jcifarmerverification b on a.F_REG_NO = b.regno left join tbl_states st on a.F_STATE = st.id";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		FarmerRegModel farmerReg = new FarmerRegModel();
		List<FarmerRegModelDTO> ll = new ArrayList<>();
		for(Object[] row: rows) {
			int F_ID = (int) row[0];
			String farmerName = (String) row[1];
			String address = (String) row[2];
			String mobile = (String)row[3];
			String branch = (String)row[11];
			String accountNumber = (String)row[13];
			String bankMandateForm= (String)row[15];
			String BankDoc= (String)row[16];
			String status = null;
			String vRegNo = (String)row[28];
			String vIFSC = (String) row[12];
			String REGno = (String)row[22];
			String RegBy = (String)row[6];
			String state = (String)row[43];
			String district = (String)row[28];
			String block = (String)row[30];
			int isVerified =0;
			if (row[17] !=null) {
				isVerified = (int) row[17];
			}
			FarmerRegModelDTO farmersDetailsDTO = new FarmerRegModelDTO();
			farmersDetailsDTO.setF_NAME(farmerName);
			farmersDetailsDTO.setF_ID(F_ID);
			farmersDetailsDTO.setAddress(address);
			farmersDetailsDTO.setF_MOBILE(mobile);
			farmersDetailsDTO.setF_BANK_BRANCH(branch);
			farmersDetailsDTO.setF_AC_NO(accountNumber);
			farmersDetailsDTO.setRegno(REGno);
			farmersDetailsDTO.setF_REG_BY(RegBy);
			farmersDetailsDTO.setF_BANK_DOC(BankDoc);
			farmersDetailsDTO.setIS_VERIFIED(isVerified);
			farmersDetailsDTO.setF_DOC_Mandate(bankMandateForm);
			farmersDetailsDTO.setState(state);
			farmersDetailsDTO.setDistrict(district);
			farmersDetailsDTO.setBlock(block);
			ll.add(farmersDetailsDTO);
		}
		 return ll;
	}

	@Override
	public boolean updateVerificationStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
		boolean returnStatus=false;
		try {
			Query q=session.createQuery("update FarmerRegModel set IS_VERIFIED=1 where F_ID=:m");
			//Query q=session.createQuery("update FarmerRegModel set IS_VERIFIED=1, F_VERFIED_DATE=SYSDATETIME() where F_ID=:m");
			q.setParameter("m",id);
			int status=q.executeUpdate();
			if(status==1) {
				returnStatus =true;
				return returnStatus;
			} else {
				returnStatus =false;
				return returnStatus;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return returnStatus;
	}

	@Override
	public boolean validateAccount(String accountNo) {
		List<Integer> result = new ArrayList<>();
		//System.out.println(accountNo);
		String querystr = "select * from jcirmt where F_AC_NO ='"+accountNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean accMatched = rows.isEmpty();		// returns true if no account found in db
		if(accMatched) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean validateAdhar(String aadharNo) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jcirmt where F_ID_PROF_No ='"+aadharNo+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//System.out.println("you are in DAO layer");
		boolean adhrMatched = rows.isEmpty();		// returns true if no aadhar number is found in db
		if(adhrMatched) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String findRegno(String dpcid, String region) { 
		
		String querystr = "select max(F_REG_NO) from jcirmt where F_REG_NO like '"+region+dpcid+"%'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
	 
		List<Object[]> rows = query.list();
		//System.out.println("rows = "+rows.toString()+rows.size());
		Object row = rows.get(0);
		 
		if(row!=null) {
		//System.out.println("row = "+row.toString());
	 
		return row.toString(); }
		else {
			return null;
		}
	}
	
	
}
