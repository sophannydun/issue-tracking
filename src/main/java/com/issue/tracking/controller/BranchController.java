package com.issue.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.issue.tracking.model.Branch;
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
		return "branch/branch";
	}
	@GetMapping("/branch/{branchId}")
	public String findBranchById(@PathVariable ("branchId") Integer branchId, Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Branch branch =null;
		model.addAttribute("loginUser", loginUser);
		if(branchId==null){
			branch= new Branch();
		}
		branch = branchServiceImp.findBranchById(branchId);
		model.addAttribute("branch", branch);
		return "/branch/branchdetail";
	}
}
