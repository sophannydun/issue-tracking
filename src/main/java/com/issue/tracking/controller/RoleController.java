package com.issue.tracking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.issue.tracking.model.Role;
import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofitImp;
@Controller
public class RoleController {
	
	@Autowired
	private RoleServiceRetrofitImp roleServiceRetrofit;
	List<Role> roles;
	@GetMapping("/roles")
	public String RolePage(Model model) throws IOException{
			roles=roleServiceRetrofit.getAllRoles();
			model.addAttribute("roles", roles);
		return "role/role";
		
	}
	
	@DeleteMapping("/roles/remove")
	public String removeRole(Integer id){
		return "";
	}
	
	@GetMapping("/roles/addRole")
	public String addRole(){
		return "/role/addRole";
	}
}
