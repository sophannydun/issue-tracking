package com.issue.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.issue.tracking.model.Role;
import com.issue.tracking.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/role")
	public String RolePage(Model model){
		List<Role> roles=roleService.getAllRoles();
		for (int i = 0; i < roles.size(); i++) {
		     System.out.println(roles.get(i).toString());
		}
		model.addAttribute("roles", roles);
		return "role/role";
	}
}
