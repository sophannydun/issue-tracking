package com.issue.tracking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.UserServiceRetrofitImp;



@Controller
public class UserController {
	@Autowired
	private UserServiceRetrofitImp userServiceRetrofitImp;
	List<User> users;
	User user;
	// @RequestMapping(value="/index")
		@GetMapping(value = {"/user"})
		public String index(Model model) throws IOException {	
			users=userServiceRetrofitImp.getAllUsers();
			model.addAttribute("users", users);
			return "user/user";
		}
		
		@GetMapping("/user/{userId}")
		public String userDetail(@PathVariable(value="userId") Integer userId, Model model) throws IOException{
			user=userServiceRetrofitImp.findUserById(userId);
			if(user==null){
				model.addAttribute("user", new User());
			}
			model.addAttribute("user",user);
			return "/user/userdetail";
		}
		@GetMapping("/user/edit/{userId}")
		public String userEdit(@PathVariable(value="userId") Integer userId, Model model) throws IOException{
			user=userServiceRetrofitImp.findUserById(userId);
			if(user==null){
				model.addAttribute("user", new User());
			}
			model.addAttribute("user",user);
			return "/user/edituser";
		}
		
		@GetMapping("/user/sbform")
		public String sbForm(){
			return "/user/sbform";
		}
		
		@Autowired
		private UserDetailsService userDetailService;
		
		@GetMapping("/user/userDetail")
		public String loadUserByUsername(@RequestParam("username") String username) {
			User user=(User) userDetailService.loadUserByUsername(username);
			System.out.println("Client Controller User-> " +user);
			return "user/user";
		}

}
