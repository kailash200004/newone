package com.jci.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.model.UserRoleModel;
@Transactional
@Repository
public interface UserRoleDao {

	void create(UserRoleModel userrole);

	public List<UserRoleModel> getAll();

}
