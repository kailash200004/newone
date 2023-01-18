package com.jci.dao.impl;

import java.math.BigDecimal;
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

import com.jci.dao.DailyPurchaseConfDao;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.RawJuteProcurementAndPayment;

@Transactional
@Repository
public class DailyPurchaseConfDaoImpl implements DailyPurchaseConfDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().saveOrUpdate(dailyPurchaseConfModel);
	}

	@Override
	public void update(DailyPurchaseConfModel dailyPurchaseConfModel) {
		currentSession().update(dailyPurchaseConfModel);

	}

	@Override
	public DailyPurchaseConfModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from dbo.jcidpc where dpcid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public DailyPurchaseConfModel find(int id) {
		return (DailyPurchaseConfModel) currentSession().get(DailyPurchaseConfModel.class, id);
	}

	@Override
	public List<DailyPurchaseConfModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(DailyPurchaseConfModel.class);
		List<DailyPurchaseConfModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(DailyPurchaseConfModel dailyPurchaseConfModel) {
		this.sessionFactory.getCurrentSession().save(dailyPurchaseConfModel);
		return false;
	}

	@Override
	public List<DailyPurchaseConfModel> dpc2() {
		List<DailyPurchaseConfModel> dpclist = new ArrayList<>();
		String querystr="";
		String querystr1="";
		String querystr2="";
		String querystr4="";
		int j;
		List<Object[]> result1 = new ArrayList<>();
		List<Object[]> result = new ArrayList<>();
		
		
		querystr2= "select ptsid from jciprocurement where flag_dpc2 = 0 group by ptsid,datepurchase,cropyr,jutevariety,placeofpurchase ";
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		SQLQuery query2 = session2.createSQLQuery(querystr2);
		result1 = query2.list();
		String ptsid = result1.toString(); 
		ptsid = result1.toString() .replace("]", "");
		ptsid = ptsid.toString() .replace("[", "");
		System.out.println("ptsid============>>>>>>>>>>>>>>  "+ptsid);
			

		querystr1 = "select  (sum(x.g1)/sum(x.netqty))as g11, (sum(x.g2)/sum(x.netqty)) as g22, (sum(x.g3)/sum(x.netqty))as g33, (sum(x.g4)/sum(x.netqty))as g44, (sum(x.g5)/sum(x.netqty))as g55, (sum(x.g6)/sum(x.netqty))as g66, (sum(x.g7)/sum(x.netqty)) as g77, (sum(x.g8)/sum(x.netqty)) as g88,x.datepurchase,x.cropyr,x.jutevariety,x.placeofpurchase,sum(x.netqty)as netqty, x.basis as basis, (sum(x.value)/sum(x.netqty))as garsat\n"
				+ "				\n"
				+ "				from\n"
				+ "				(select netquantity as netqty,(grasatrate*netquantity)as value,\n"
				+ "				(grade1 * netquantity) as g1,\n"
				+ "				(grade2 * netquantity) as g2,\n"
				+ "				(grade3 * netquantity) as g3,\n"
				+ "				(grade4 * netquantity) as g4,\n"
				+ "				(grade5 * netquantity) as g5,\n"
				+ "				(grade6 * netquantity) as g6,\n"
				+ "				(grade7 * netquantity) as g7,\n"
				+ "				(grade8 * netquantity) as g8,\n"
				+ "				datepurchase, cropyr,jutevariety,placeofpurchase, basis from jciprocurement\n"
				+ "				where flag_dpc2 = 0\n"
				+ "				group by grade1, grade2, grade3,grade4, grade5, grade6, grade7, grade8, netquantity,grasatrate,datepurchase,cropyr,jutevariety,placeofpurchase, basis)x \n"
				+ "				group by x.datepurchase,x.cropyr,x.jutevariety,x.placeofpurchase, x.basis";
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr1);
		result = query.list();
		try {
		//for(int i=0; i<query.list().size(); i++) {
			for(Object[] o: result) {
			System.out.println("=========>>>>>>>>>>>>query.list().size()  "+query.list().size());
			double multi=0.0;
			double addition=0.0;
			DailyPurchaseConfModel dailyPurchaseConfModel= new DailyPurchaseConfModel();
			//Object[] o = result.get(i);
			System.out.println("=========>>>>>>>>>>>>Object  "+o[0].toString());
			double grade[] = new double[8]; 
			String variety= (String)o[10];
			String cropyr=(String)o[9];
			String dpcid=(String)o[11];
			double netqty =((BigDecimal)o[12]).doubleValue();
			double garsat =((BigDecimal)o[14]).doubleValue();
			double grade0 =((BigDecimal)o[0]).doubleValue();
			double grade1 =((BigDecimal)o[1]).doubleValue();
			double grade2 =((BigDecimal)o[2]).doubleValue();
			double grade3 =((BigDecimal)o[3]).doubleValue();
			double grade4 =((BigDecimal)o[4]).doubleValue();
			double grade5 =((BigDecimal)o[5]).doubleValue();
			double grade6 =((BigDecimal)o[6]).doubleValue();
			double grade7 =((BigDecimal)o[7]).doubleValue();
			  final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			  
			  String datepurchase =formatter1.format(o[8]);
			
			String basis= (String)o[13];
		
			dailyPurchaseConfModel.setGrade1(grade0);
			dailyPurchaseConfModel.setGrade2(grade1);
			dailyPurchaseConfModel.setGrade3(grade2);
			dailyPurchaseConfModel.setGrade4(grade3);
			dailyPurchaseConfModel.setGrade5(grade4);
			dailyPurchaseConfModel.setGrade6(grade5);
			dailyPurchaseConfModel.setGrade7(grade6);
			dailyPurchaseConfModel.setGrade8(grade7);
			dailyPurchaseConfModel.setDatepurchase(datepurchase);
			
			if(basis.equalsIgnoreCase("commercial")) {
			querystr = "SELECT top 1 grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcijutepricesforcommercial where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%' and dpc like '%"+dpcid+"%'"+"order by effectDate desc ";
			}
			else if(basis.equalsIgnoreCase("msp")) {
				querystr =  "SELECT  grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8 FROM jcimspgradesprice where crop_yr='"+cropyr + "' and jute_variety like '"+ variety+"%'";
				
			}
			Session session1 = sessionFactory.getCurrentSession();
			Transaction tx1 = session1.beginTransaction();
			SQLQuery query1 = session1.createSQLQuery(querystr);
			List<Object[]> prices = new ArrayList<>();
			prices = query1.list();
			
			double gradeprice[] = new double[8];
			double difference[] = new double[8];
			 
			for(Object[] p :prices) {
			double gradefive=((BigDecimal) p[4]).doubleValue();
			
			for (j = 0; j < 8; j++){
				
				
						grade[j]= ((BigDecimal)o[j]).doubleValue();
					
								gradeprice[j]=((BigDecimal) p[j]).doubleValue();
					
												if(grade[j]!=0)
													{	
															difference[j]= gradeprice[j]-gradefive ;
												     
												      		multi=(difference[j] *  (grade[j]/100)) ;
												      
												      		addition += multi;
											     		
																
														//System.out.println("addition inside================>>>>>>>>>>>>>> "+addition);
								      		
												}  
												
			}
					//	System.out.println("addition outside================>>>>>>>>>>>>>> "+addition);
						//System.out.println("garsat-addition================>>>>>>>>>>>>>> "+(garsat-addition));
						dailyPurchaseConfModel.setTd5base(garsat-addition);
	
				
				
			}
			querystr4= "UPDATE jciprocurement SET flag_dpc2 = 1 WHERE ptsid in ("+ptsid+");";
			System.out.println("querystr3============>>>>>>>>>>>>>>  "+querystr4);
			Session session4 = sessionFactory.getCurrentSession();
			Transaction tx4 = session4.beginTransaction();
			SQLQuery query4 = session4.createSQLQuery(querystr4);
			int one = query4.executeUpdate();
			System.out.println("====================== " +one);
			dailyPurchaseConfModel.setGarsat(garsat);
			dailyPurchaseConfModel.setBasis(basis);
			dailyPurchaseConfModel.setCropyr(cropyr);
			dailyPurchaseConfModel.setPlaceofpurchase(dpcid);
			dailyPurchaseConfModel.setNetquantity(netqty);
			
			dailyPurchaseConfModel.setJutevariety(variety);
			
			System.out.println("dailyPurchaseConfModel============>>>>>>>>>>>>>>  "+dailyPurchaseConfModel.toString());
			dpclist.add(dailyPurchaseConfModel);
	 }
		}
        catch (Exception e) {
            System.out.println(e);
        }
	//	System.out.println("dpclist==============>>>>>>>>>>>> "+dpclist);
		return dpclist;

	
  }
}