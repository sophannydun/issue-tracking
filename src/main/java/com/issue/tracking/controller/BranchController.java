package com.issue.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.BranchServiceImp;

@Controller
public class BranchController {

	@Autowired
	private BranchServiceImp branchServiceImp;
	@GetMapping("/branch")
	public String allBranches(Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/* String name = user.getUsername(); //get logged in username */
		model.addAttribute("loginUser", loginUser);
		System.out.println(branchServiceImp.findAllBranch());
		model.addAttribute("branches", branchServiceImp.findAllBranch());
		return "user/user";
	}
}
