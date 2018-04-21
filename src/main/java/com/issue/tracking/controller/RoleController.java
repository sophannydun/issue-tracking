package com.issue.tracking.controller;

import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.issue.tracking.model.Role;
import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofit;
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
	
	@GetMapping("/roles/{id}")
	public String findRoleById(@PathVariable("id") Integer id,Model model) throws IOException{
		Role role=roleServiceRetrofit.findRoleById(id);
		if(role==null){
			model.addAttribute("role",new Role());
		}
		model.addAttribute("role", role);
		
		return "/role/roledetail";
	}
	
	
	
	@DeleteMapping("/roles/remove/{id}")
	public String removeRole(@PathVariable("id") Integer id) throws IOException{
		Boolean status=false;
		System.out.println(status +" Removed "+ id);
		status=roleServiceRetrofit.removeRoleById(id);
		System.out.println(status +" Removed "+ id);
		return "redirect:/roles";
	}
	// retrofit with api
	// form with controler
	
	//calling RoleServiceRetrofit via RequestParam that calling API @RequestParam in Retrofit use @Query
	/*@DeleteMapping("/roles/remove")
	public String removeRole(@RequestParam("id") Integer id) throws IOException{
		Boolean status=false;
		System.out.println(status +" Removed "+ id);
		status=roleServiceRetrofit.removeRoleById(id);
		System.out.println(status +" Removed "+ id);
		return "redirect:/roles";
	}*/
	
	@GetMapping("/roles/addRole")
	public String addRole(){
		return "/role/addRole";
	}
	@PostMapping("/roles/addRole")
	public String actionAddRole(Role role) throws IOException{
		Boolean status=roleServiceRetrofit.createRole(role);
		System.out.println(status +" Created "+ role);
		//redirect to mapped /roles
		return "redirect:/roles";
	}
	@GetMapping("/roles/edit/{id}")
	public String editRole(@PathVariable("id") Integer id,Model model) throws IOException{
		Role role=roleServiceRetrofit.findRoleById(id);
		if(role==null){
			model.addAttribute("role",new Role());
		}
		model.addAttribute("role", role);
		
		return "/role/editrole";
	}
	@PutMapping("/roles/edit")
	public String actionEditRole(Role role) throws IOException{
		Boolean status=roleServiceRetrofit.updateRoleById(role);
		System.out.println(status +" Updated "+ role);
		//redirect to mapped /roles
		return "redirect:/roles";
	}
}
