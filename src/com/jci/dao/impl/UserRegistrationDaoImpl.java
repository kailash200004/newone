package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UserRegistrationDao;
import com.jci.model.UserRegistrationModel;

@Transactional
@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void create(UserRegistrationModel userRegistration) {
		currentSession().saveOrUpdate(userRegistration);
	}

	@Override
	public void update(UserRegistrationModel userRegistration) {
		currentSession().update(userRegistration);
	}

	@Override
	public UserRegistrationModel edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		UserRegistrationModel farmerRegistrationModel = new UserRegistrationModel();
		String hql = "Delete from jciumt where refid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public UserRegistrationModel find(int id) {
		return (UserRegistrationModel) currentSession().get(UserRegistrationModel.class, id);
	}

	@Override
	public List<UserRegistrationModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(UserRegistrationModel.class);
		List<UserRegistrationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(UserRegistrationModel userRegistration) {
		this.sessionFactory.getCurrentSession().save(userRegistration);
		return false;
	}

	@Override
	public  String loginCheck(String userName, String password) {
		List<Integer> result = new ArrayList<>();
		String querystr = "select * from jciumt where username ='"+userName+"' and password ='"+password+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		boolean isPresent = rows.isEmpty();
		if(isPresent) {
			return null;
		}else {
			return rows.get(0)[13].toString();
		}
	}

	@Override
	public boolean validateEmail(String Email) {
		String querystr = "select * from jciumt where email ='"+Email+"'";
		Session session = sessionFactory.getCurrentSession();
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
	public int getUserId(String Email) {
		String querystr = "select refid from jciumt where username ='"+Email+"'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> userList = query.list();
		if(userList.size()>1) {
			Log.info("two users exist of same email Id");
			return 0;
		}
		else if(userList.size()==1){
			int userIdString = userList.get(0);
			return userIdString;
		}
		else {
			Log.info("no user exist with such id");
			return 0;
		}
	}

	@Override
	public String getUserDpc(int userId) {
		String querystr = "select dpcId from jciumt where refid ='"+userId+"'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		if(userList.size()>1) {
			Log.info("One user can't have two dpc id");
			return "0";
		}
		else if(userList.size()==1){
			String userIdString = userList.get(0);
			return userIdString;
		}
		else {
			Log.info("no user exist with such id");
			return "0";
		}
	}

	@Override
	public String getUserRegion(int userId) {
		//String querystr = "select regionId from jciumt where username ='"+userId+"'";
		//Session session = sessionFactory.getCurrentSession();

		String querystr = "select regionId from jciumt where refid ='"+userId+"'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<String> userList = query.list();
		if(userList.size()>1) {
			Log.info("One user can't have two dpc id");
			return "0";
		}
		else if(userList.size()==1){
			String userIdString = userList.get(0);
			return userIdString;
		}
		else {
			Log.info("no user exist with such id");
			return "0";
		}
	}

	@Override
	public int getUserRoleId(int userId) {
		//String querystr = "select regionId from jciumt where username ='"+userId+"'";
		//Session session = sessionFactory.getCurrentSession();

		String querystr = "select roleId from jciumt where refid ='"+userId+"'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Integer> userList = query.list();
		
			int roleId = userList.get(0);
			return roleId;
		
		
	}
	@Override
	public UserRegistrationModel getuserprofile(int refid) {
		List<UserRegistrationModel> result = new ArrayList<>();
		String querystr = "Select a.username, a.employeeid, a.email, a.employeename, a.mobileno, b.centername, c.roname, d.zonename from jciumt a left Join jcipurchasecenter b on a.dpcId = b.CENTER_CODE left join jcirodetails c on a.regionId = c.roid left join jcizones d on a.zoneId=d.zonecode where a.refid='"+refid+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		//UserRegistrationModel ll = new UserRegistrationModel();
		UserRegistrationModel userRegistration = new UserRegistrationModel();
		for(Object[] row: rows) {
			String username =  (String) row[0];
			String employeeid =  (String) row[1];
			String email =  (String) row[2];
			String employeename =  (String) row[3];
			String mobileno =  (String) row[4];
			String centername =  (String) row[5];
			String roname =  (String) row[6];
			String zonename =  (String) row[7];
			
			//System.out.println("zonessssss"+ zonename);
			userRegistration.setUsername(username);
			userRegistration.setEmployeeid(employeeid);
			userRegistration.setEmail(email);
			userRegistration.setEmployeename(employeename);
			userRegistration.setMobileno(mobileno);
			userRegistration.setCentername(centername);
			userRegistration.setRoname(roname);
			userRegistration.setZonename(zonename);
			//ll
			//ll.add(userRegistration);
			
	}
	
		 return userRegistration;
	
	
			
			
	}	

	@Override
	public String getdpc_center(String dpcIdd) {
		String querystr = "select centername FROM jcipurchasecenter where CENTER_CODE='"+dpcIdd+"'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(querystr);
		String dpc_center = query.list().toString();
		dpc_center= dpc_center.replace("[", "");
		dpc_center= dpc_center.replace("]", "");
			
			//System.out.println("dpccenter==============>>>>>>>>>>>>>>>>>>  "+dpc_center);
			return dpc_center;
	}	
	
	
	@Override
	public int getRefId(String email) {
		//String querystr = "select dpcId from jciumt where refid ='"+userId+"'";
				String querystr = "select refid from jciumt where username='"+email+"'";
				Session session = sessionFactory.getCurrentSession();
				SQLQuery query = session.createSQLQuery(querystr);
				List<Integer> userList = query.list();
				System.out.println("refid===>>>>> "+userList);
				if(!userList.isEmpty()) {
					return userList.get(0);
					//return "0";
				}
				else {
					return 0;
				}
	}	
}
