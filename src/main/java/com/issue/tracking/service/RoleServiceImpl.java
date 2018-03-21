package com.issue.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.Role;
import com.issue.tracking.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	@Override
	public boolean save(Role role) {
		return roleRepository.save(role);
	}
	@Override
	public Role findRoleById(Integer id) {
		return roleRepository.findRoleById(id);
	}
	@Override
	public void remove(Integer id) {
		roleRepository.remove(id);
	}
	@Override
	public boolean update(Role role) {
		return roleRepository.update(role);
	}

}
