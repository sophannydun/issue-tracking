package com.issue.tracking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.issue.tracking.model.Branch;
import com.issue.tracking.model.Department;
import com.issue.tracking.model.Role;
import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.BranchServiceImp;
import com.issue.tracking.repository.retrofit.service.DepartmentServiceImp;
import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofitImp;
import com.issue.tracking.repository.retrofit.service.UserServiceRetrofitImp;

@Controller
public class UserController {
	@Autowired
	private UserServiceRetrofitImp userServiceRetrofitImp;
	@Autowired
	private RoleServiceRetrofitImp roleServiceRetrofit;
	@Autowired
	private DepartmentServiceImp departmentServiceImp;
	
	@Autowired
	private BranchServiceImp branchServiceImp;
	List<User> users;
	User user;

	// @RequestMapping(value="/index")
	@GetMapping(value = { "/user" })
	public String index(Model model) throws IOException {
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		users = userServiceRetrofitImp.getAllUsers();
		model.addAttribute("users", users);
		return "user/user";
	}

	@GetMapping("/user/{userId}")
	public String userDetail(@PathVariable(value = "userId") Integer userId, Model model) throws IOException {
		user = userServiceRetrofitImp.findUserById(userId);
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		if (user == null) {
			model.addAttribute("user", new User());
		}
		model.addAttribute("user", user);
		return "/user/userdetail";
	}

	@GetMapping("/user/addUser")
	public String addUser(Model model) throws IOException {
		List<Branch> branches=branchServiceImp.findAllBranch();
		List<Department> departments=departmentServiceImp.getAllDepartment();
		List<Role> roles = roleServiceRetrofit.getAllRoles();
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);	
		System.out.println("B4 get login user" + loginUser);
		if (user == null) {
			model.addAttribute("roles", new Role());
			model.addAttribute("departments", new Department());
			//model.addAttribute("branches", new Branch());
		}
		model.addAttribute("roles", roles);
		model.addAttribute("departments", departments);
		System.out.println("Controller Client branches -> " + branchServiceImp.findAllBranch());
		model.addAttribute("branches", branches);
		
		return "/user/adduser";
	}

	@PostMapping("/user/addUser")
	public String actionAddUser(
			@RequestParam(value = "roleIds", required = false, defaultValue = "1") Integer[] roleIds, Model model,
			User user) throws IOException {
		List<Role> roles = new ArrayList<>();
		for (Integer rId : roleIds) {
			roles.add(new Role(rId));
		}
		user.setRoles(roles);
		System.out.println("Client from html User New: " + user);
		userServiceRetrofitImp.createUser(user);
		return "redirect:/user";
	}

	@PutMapping("/user/edit")
	public String actionUpdateUserByUserId(
			@RequestParam(value = "roleIds", required = false, defaultValue = "1") Integer[] roleIds, Model model,
			User user) throws IOException {
		
		List<Role> roles = new ArrayList<>();
		for (Integer rId : roleIds) {
			roles.add(new Role(rId));
		}
		user.setRoles(roles);
		System.out.println("Client from html User New: " + user);
		userServiceRetrofitImp.updateUserByUserId(user);
		return "redirect:/user";
	}

	@GetMapping("/user/edit/{userId}")
	public String userEdit(@PathVariable(value = "userId") Integer userId, Model model) throws IOException {
		List<Branch> branches=branchServiceImp.findAllBranch();
		List<Department> departments=departmentServiceImp.getAllDepartment();
		user = userServiceRetrofitImp.findUserById(userId);
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);	
		List<Role> roles = roleServiceRetrofit.getAllRoles();
		if (user == null) {
			model.addAttribute("user", new User());
			model.addAttribute("roles", new Role());
			model.addAttribute("departments", new Department());
			model.addAttribute("branches", new Branch());
		}
		model.addAttribute("departments", departments);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		model.addAttribute("branches", branches);
		return "/user/edituser";
	}

	@GetMapping("/user/sbform")
	public String sbForm(Model model) {
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		return "/user/sbform";
	}

	@DeleteMapping("/user/remove/{userId}")
	public String deleteUserByUserId(@PathVariable("userId") Integer userId) throws IOException {
		Boolean status = false;
		System.out.println(status + " Removed " + userId);
		status = userServiceRetrofitImp.deleteUserByUserId(userId);
		System.out.println(status + " Removed " + userId);
		return "redirect:/user";
	}

	@Autowired
	private UserDetailsService userDetailService;

	@GetMapping("/user/userDetail")
	public String loadUserByUsername(@RequestParam("username") String username) {
		User user = (User) userDetailService.loadUserByUsername(username);
		System.out.println("Client Controller User-> " + user);
		return "user/user";
	}
}