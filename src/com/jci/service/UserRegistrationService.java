package com.jci.service;

import java.util.List;

import com.jci.model.UserRegistrationModel;

public interface UserRegistrationService {
	public void create(UserRegistrationModel userRegistration);
	public void update(UserRegistrationModel userRegistration);
	public UserRegistrationModel edit(int id);
	public void delete(int id);
	public UserRegistrationModel find(int id);
	public List <UserRegistrationModel> getAll( String dpcId);
	public boolean submitform(UserRegistrationModel userRegistration);
	public String checkLogin(String usrname, String password);
	public boolean validateEmail(String Email);
	public String getUserId(int refid);
	public String getUserDpc(int userId);
	public String getUserRegion(int userId);
	public String getdpc_center(String dpcIdd);
	public int getRefId(String emailId);
	public int getUserRoleId(int userId);
	public UserRegistrationModel getuserprofile(int refid);
	public boolean validateUserMobile(String mobileNo);
	public boolean validateEmployeeid(String employeeid);
	public boolean validateusername(String username);
	public int getis_ho(String usrname);
}
