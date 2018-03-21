package com.issue.tracking.service;

import java.util.List;

import com.issue.tracking.model.Role;

public interface RoleService {
	List<Role> getAllRoles();
	public boolean save(Role role);
	public Role findRoleById(Integer id);
	public void remove(Integer id);
	public boolean update(Role role);
}
