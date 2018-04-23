package com.issue.tracking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.issue.tracking.model.Role;
import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.RoleServiceRetrofitImp;
import com.issue.tracking.repository.retrofit.service.UserServiceRetrofitImp;

@Controller
public class UserController {
	@Autowired
	private UserServiceRetrofitImp userServiceRetrofitImp;
	@Autowired
	private RoleServiceRetrofitImp roleServiceRetrofit;
	List<User> users;
	User user;

	// @RequestMapping(value="/index")
	@GetMapping(value = { "/user" })
	public String index(Model model) throws IOException {
		users = userServiceRetrofitImp.getAllUsers();
		model.addAttribute("users", users);
		return "user/user";
	}

	@GetMapping("/user/{userId}")
	public String userDetail(@PathVariable(value = "userId") Integer userId, Model model) throws IOException {
		user = userServiceRetrofitImp.findUserById(userId);
		if (user == null) {
			model.addAttribute("user", new User());
		}
		model.addAttribute("user", user);
		return "/user/userdetail";
	}

	@PostMapping("/user/addUser")
	public String addUser(@RequestParam(value = "roleIds", required = false, defaultValue = "1") Integer[] roleIds,
			Model model, User user) throws IOException {
		List<Role> roles = new ArrayList<>();
		for (Integer rId : roleIds) {
			roles.add(new Role(rId));
		}
		user.setRoles(roles);
		System.out.println(user);
		userServiceRetrofitImp.createUser(user);
		return "redirect:/user";
	}

	@GetMapping("/user/addUser")
	public String actionAddUser(Model model) throws IOException {
		List<Role> roles = roleServiceRetrofit.getAllRoles();
		if (user == null) {
			model.addAttribute("roles", new Role());
		}
		model.addAttribute("roles", roles);
		return "/user/adduser";
	}

	@GetMapping("/user/edit/{userId}")
	public String userEdit(@PathVariable(value = "userId") Integer userId, Model model) throws IOException {
		user = userServiceRetrofitImp.findUserById(userId);
		List<Role> roles = roleServiceRetrofit.getAllRoles();
		if (user == null) {
			model.addAttribute("user", new User());
			model.addAttribute("roles", new Role());
		}
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "/user/edituser";
	}

	@GetMapping("/user/sbform")
	public String sbForm() {
		return "/user/sbform";
	}

}
