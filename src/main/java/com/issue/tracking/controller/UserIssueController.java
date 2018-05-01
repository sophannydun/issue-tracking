package com.issue.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.issue.tracking.model.Issue;
import com.issue.tracking.model.IssueApproval;
import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.repository.IssueServiceClient;
import com.issue.tracking.repository.retrofit.service.UserIssueService;

@Controller
@RequestMapping("/user")
public class UserIssueController {

	@Autowired
	private UserIssueService userIssueServiceImp;
	
	
	/*@Autowired
	private IssueServiceClient issueServiceClient;*/
	@GetMapping("/issueapproval")
	public String findAllIssueApproval(Model model){
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		List<IssueApproval> issuesapprove=userIssueServiceImp.findAllIssueApproval();
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("issuesapprove", issuesapprove);
		return "issue/userissue";
	}
	/*@PutMapping("/approveissue")
	public String actionLineMangerApproval(@RequestBody Issue issue,@RequestBody IssueApproval issueApproval){
		issueServiceClient.lineManagerApproval(issue, issueApproval);
		userIssueServiceImp.createIssueApproval(issueApproval);
		return "redirect:/issueapproval";
		
	}*/
}
