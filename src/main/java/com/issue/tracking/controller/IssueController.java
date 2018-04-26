package com.issue.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.issue.tracking.model.Department;
import com.issue.tracking.model.Issue;
import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.DepartmentService;
import com.issue.tracking.repository.retrofit.service.IssueService;
import com.issue.tracking.repository.retrofit.service.IssueTypeService;

@Controller
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private IssueTypeService issueTypeService;
	
	@Autowired
	private DepartmentService departmentService;

	
	// Get all issues
	@GetMapping("/issues")
	public String issueList(Model model) {
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		List<Issue> issues = issueService.getAllIssues();		
		System.out.println(issues.toString());		
		model.addAttribute("issues", issues);
		// return "issue/index";
		return "issue/index";
	}

	//create issue
	//@GetMapping("/issue/create")
	public String createIssue() {
		return "issue/createissue";
	}
	
	
	@GetMapping("/issue/create") //@RequestMapping(value = "/issue/add")
	public String issueAddPage(Model model){	
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      /*String name = user.getUsername(); //get logged in username*/
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("issue", new Issue());	
		model.addAttribute("departments", departmentService.getAllDepartment());
		model.addAttribute("issueType", issueTypeService.getAllIssueType());
		System.out.println(departmentService.getAllDepartment());
		System.out.println( issueTypeService.getAllIssueType());
		return "issue/createissue";
	}

}
