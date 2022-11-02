package com.jci.dao.impl;

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

import com.jci.dao.RopeMakingDao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.RopeMakingModel;

@Transactional
@Repository
public class RopeMakingDaoImpl implements RopeMakingDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RopeMakingModel ropeMakingModel) {

		currentSession().saveOrUpdate(ropeMakingModel);
	}

	@Override
	public void update(RopeMakingModel ropeMakingModel) {
		currentSession().update(ropeMakingModel);

	}

	@Override
	public RopeMakingModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.jcirop where rpmrefid= '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RopeMakingModel find(int id) {
		return (RopeMakingModel) currentSession().get(RopeMakingModel.class, id);
	}

	@Override
	public List<RopeMakingModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RopeMakingModel.class);
		List<RopeMakingModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RopeMakingModel ropeMakingModel) {
		this.sessionFactory.getCurrentSession().save(ropeMakingModel);
		return false;
	}

	@Override
	public List <RopeMakingModel> ropeMakingList(int regionId) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select a.*, b.centername  from jcirop a Inner Join jcipurchasecenter b on a.placeofactivity = b.CENTER_CODE where a.placeofactivity='"+regionId+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<RopeMakingModel> ll = new ArrayList<>();
		for(Object[] row: rows) {
			int rpmrefid = (int)row[0];
			String datereport = (String)row[1];
			String basis = (String)row[2];
			String cropyr = (String)row[4];
			String ropeUsed = (String)row[6];
			String binNo = (String)row[8];
			String juteVariety = (String)row[9];
			String ropeMade = (String)row[10];
			String ropeBalance = (String)row[15];
			String dpcName = (String)row[17];
			RopeMakingModel rope = new RopeMakingModel();
			rope.setBasis(basis);
			rope.setBinno(binNo);
			rope.setCreateddate(new Date());
			rope.setCropyr(cropyr);
			rope.setDpc(dpcName);
			rope.setDatereport(new Date());
			rope.setRopeused(ropeUsed);
			rope.setRope_balance(ropeBalance);
			rope.setJutevariety(juteVariety);
			rope.setRopemade(ropeMade);
			rope.setRpmrefid(rpmrefid);
			ll.add(rope);
			//ropeMaking.add
			//ropeMaking.add
//			int F_ID = (int) row[0];
//			String farmerName = (String) row[1];
//			String address = (String) row[2];
//			String mobile = (String)row[3];
//			String branch = (String)row[11];
//			String accountNumber = (String)row[13];
//			String bankMandateForm= (String)row[15];
//			String BankDoc= (String)row[16];
//			String status = null;
//			String vRegNo = (String)row[28];
//			String vIFSC = (String) row[12];
//			String REGno = (String)row[22];
//			String RegBy = (String)row[6];
//			String state = (String)row[43];
//			String district = (String)row[28];
//			String block = (String)row[30];
//			int isVerified =0;
//			if (row[17] !=null) {
//				isVerified = (int) row[17];
//			}
//			FarmerRegModelDTO farmersDetailsDTO = new FarmerRegModelDTO();
//			farmersDetailsDTO.setF_NAME(farmerName);
//			farmersDetailsDTO.setF_ID(F_ID);
//			farmersDetailsDTO.setAddress(address);
//			farmersDetailsDTO.setF_MOBILE(mobile);
//			farmersDetailsDTO.setF_BANK_BRANCH(branch);
//			farmersDetailsDTO.setF_AC_NO(accountNumber);
//			farmersDetailsDTO.setRegno(REGno);
//			farmersDetailsDTO.setF_REG_BY(RegBy);
//			farmersDetailsDTO.setF_BANK_DOC(BankDoc);
//			farmersDetailsDTO.setIS_VERIFIED((int)isVerified);
//			farmersDetailsDTO.setF_DOC_Mandate(bankMandateForm);
//			farmersDetailsDTO.setState(state);
//			farmersDetailsDTO.setDistrict(district);
//			farmersDetailsDTO.setBlock(block);
			// ll.add(farmersDetailsDTO);
		}
		 return ll;
	}


}
