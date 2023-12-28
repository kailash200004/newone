package com.jci.dao.impl_phase2;

import java.util.List;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jci.dao_phase2.GenerationofBillDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.GenerationOfBillSupplyModel;

@Repository
@Transactional
public class GenerationofBillDaoImpl implements GenerationofBillDao {
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(GenerationOfBillSupplyModel generationOfBillSupplyModel) {
		
		currentSession().save(generationOfBillSupplyModel);
	}
	@Override
    public List<GenerationOfBillSupplyModel> getAll(){
        Criteria criteria = currentSession().createCriteria(GenerationOfBillSupplyModel.class);
        return criteria.list();
    }

	@Override
	public List<Object> ChallanNo() {
		String sql="select  Challan_no  from  jcidispatch_details";
		 List<Object>resultList1= (List<Object>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	    return resultList1;
	}

	@Override
	public  List<Object[]> contarctno(String st) {
		String sql="select  Contract_No ,Creation_date from  jcidispatch_details where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}
	@Override
	public  List<Object[]> Dispatchentry(String st) {
		String sql="select  Crop_year,Bale_mark,Jute_variety,No_of_bales,Nominal_wt,Rate,Nominal_qty  from  jcidispatch_details where  Challan_no='" + st + "' ";
		 List<Object[]>resultList1= (List<Object[]>)this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		    return resultList1;

				
	}

	@Override
	public String billofsupplyno(String st) {
		String sql = "SELECT  count(*) FROM jcibos_generation WHERE Bill_of_supply_no = '" + st + "' ";
		int  total = (Integer)this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();		
		
		
		if(total>0)
			return "1";
		else 
			return "0";

	}



}

	

