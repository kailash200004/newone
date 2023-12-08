package com.jci.securityfilters;

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
    	Session session = sessionFactory.openSession();
    	   String email = LoginController.useremail1;
           System.err.println("repo"+email);

           String hql = "update checkConcurrentlogin set flag = 'logout' where email ='"+email+"'";
           int rowsUpdated = session.createSQLQuery(hql)
               .setParameter("email", email)
               .executeUpdate();
           
             //String hql = "update checkConcurrentlogin set flag = 'logout' where email ='"+email+"'";
             System.out.println("repo"+email);
             //this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
			System.out.println("repo111111"+email);
    }

}
