package com.issue.tracking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.issue.tracking.model.Department;
import com.issue.tracking.model.Issue;
import com.issue.tracking.model.Role;
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
	
	@PostMapping("/issues/addIssue")
	public String actionAddIssue(Issue issue) throws IOException {
		Boolean status = issueService.createIssue(issue);
		System.out.println(status + " Created " + issue);
		return "redirect:/issues";
	}
	@GetMapping("/approveissue/{issueId}")
	public String approveIssue(@PathVariable ("issueId") Integer issueId, Model model){
		User loginUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Issue issue=null;
		issue=issueService.findIssueById(issueId);
		model.addAttribute("issue", issue);
		model.addAttribute("loginUser", loginUser);
		return "/issue/approveissue";
	}

}
