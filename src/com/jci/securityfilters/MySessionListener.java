package com.jci.securityfilters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.jci.controller.LoginController;
import com.jci.service.UserRegistrationService;

public class MySessionListener implements HttpSessionListener {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	UserRegistrationService userRegService;
	
	@Autowired
	HttpServletRequest request;
	
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Session creation logic, if needed
    }
    
    static {
    	System.out.println("static block");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Retrieve user information from the session
       // String flag = (String)se.getSession().getAttribute("Concurrentloginflag");
        //String email = (String)se.getSession().getAttribute("usrname");
    	String email =(String)request.getSession().getAttribute("usrname");

    	System.err.println("repo"+email);

           String hql = "update checkConcurrentlogin set flag = 'logout' where email ='"+email+"'";
           int rowsUpdated = (int) currentSession().createSQLQuery(hql)
               .setParameter("email", email)
               .uniqueResult();
           
             //String hql = "update checkConcurrentlogin set flag = 'logout' where email ='"+email+"'";
             System.out.println("repo"+email);
             //this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			System.out.println("repo111111"+email);
    }

}
