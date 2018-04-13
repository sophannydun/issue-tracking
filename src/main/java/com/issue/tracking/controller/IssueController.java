package com.issue.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.issue.tracking.model.Issue;
import com.issue.tracking.repository.retrofit.service.IssueService;

@Controller
public class IssueController {

	@Autowired
	private IssueService issueService;

	@GetMapping("/issues")
	public String issueList(Model model) {

		List<Issue> issues = issueService.getAllIssues();
		System.out.println(issues.toString());
		// model.addAttribute("issues", issues);
		// return "issue/index";
		return "issue/index";
	}

}
