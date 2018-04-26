package com.issue.tracking.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.issue.tracking.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		return "home/index";
	}
    
	// Sample Template 
	@RequestMapping("/index")
	public String index() {
		return "index1";
	}

	@RequestMapping("/index1")
	public String index1() {
		return "index1";
	}

	@RequestMapping("/index2")
	public String index2() {
		return "index2";
	}

	@RequestMapping("/index3")
	public String index3() {
		return "index3";
	}

}
