package com.jci.dao;

import java.util.List;

import com.jci.model.UserRegistrationModel;

public interface UserRegistrationDao {
	public void create(UserRegistrationModel userRegistration);
	public void update(UserRegistrationModel userRegistration);
	public UserRegistrationModel edit(int id);
	public void delete(int id);
	public UserRegistrationModel find(int id);
	public List <UserRegistrationModel> getAll();
	public boolean submitform(UserRegistrationModel userRegistration);
	public String loginCheck(String userName, String password);
	public boolean validateEmail(String Email);
	public int getUserId(String Email);
	public String getUserDpc(int userId);
	public String getUserRegion(int userId);
}
