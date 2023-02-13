package com.jci.service;

import org.springframework.stereotype.Service;

import com.jci.model.UserPriviligeModel;
@Service
public interface UserPriviligeService {

	void create(UserPriviligeModel role_Id);
	public String getUserPrivilegeListing(int role_Id);


}
