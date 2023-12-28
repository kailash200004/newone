package com.jci.dao.impl_phase2;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.EntryofGradeCompositionDao;
import com.jci.model.EntryDerivativePrice;
import com.jci.model.EntryofGradeCompositionModel;
import com.lowagie.text.Element;

@Transactional
@Repository
public class EntryofGradeCompositionDaoImpl implements EntryofGradeCompositionDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofGradeCompositionModel egc) {
		currentSession().saveOrUpdate(egc);
	}

	@Override
	public List<Object> getAllJuteCombination() {
		String sql = "select * from jutecombination";
		List<Object> list = (List<Object>) currentSession().createSQLQuery(sql).list();
		return list;
	}

	@Override
	public List<String> getAllLabelName() {
		String sql = "select Distinct Label_name from jcigrade_composition";
		List<String> list = (List<String>) currentSession().createSQLQuery(sql).list();
		return list;
	}
	
//	@Override
//	public Date convertToDate(String date) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	   Date finalDate = null;
//		try {
//			finalDate =  simpleDateFormat.parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return finalDate;
//	}
// 
//	@Override
//	public List<EntryofGradeCompositionModel> getAllEGC() {
//		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(EntryofGradeCompositionModel.class);
//		
//		List<EntryofGradeCompositionModel> list = c.list();
//		list.sort((entry1, entry2) -> {
//		    // Assuming you have a method to convert the date to the desired format
//		    Date date1 = convertToDate(entry1.getCreated_date());
//		    Date date2 = convertToDate(entry2.getCreated_date());
//
//		    // Compare the dates
//		    return date2.compareTo(date1);
//		});
//	
 
	@Override
	public List<EntryofGradeCompositionModel> getAllEGC() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(EntryofGradeCompositionModel.class)
				.addOrder(Order.desc("created_date"));
		List<EntryofGradeCompositionModel> ll = c.list();
		return ll;

	}

	@Override
	public void update(EntryofGradeCompositionModel egc) {
		currentSession().saveOrUpdate(egc);
	}

	@Override
	public EntryofGradeCompositionModel edit(BigInteger id) {

		return (EntryofGradeCompositionModel) currentSession().get(EntryofGradeCompositionModel.class, id);
	}

	@Override
	public void delete(BigInteger id) {
		String hql = "Delete from dbo.jcigrade_composition where grade_id= '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public EntryofGradeCompositionModel getSecificGradeComposition(BigInteger grade_id) {
		EntryofGradeCompositionModel entryofGrade = (EntryofGradeCompositionModel) this.sessionFactory
				.getCurrentSession().get(EntryofGradeCompositionModel.class, grade_id);
		return entryofGrade;
	}

	@Override
	public void updateJuteVariety(String juteVariety, String labelName, String preJuteVariety) {
		String sqlString = "update dbo.jcigrade_composition set Jute_combination ='" + juteVariety + "'"
				+ " where Label_name ='" + labelName + "' and Jute_combination='" + preJuteVariety + "'";
		this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).executeUpdate();
	}

	@Override
	public boolean isValidLabelName(String labelName) {
		String sqlString = "select count(Label_name) from jcigrade_composition where Label_name ='" + labelName+"'";
		Query q = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString);
		int count = (Integer) q.uniqueResult();
         System.out.println(labelName);
		System.out.println(count);
	
		return count > 0 ? false : true;
	}
}
