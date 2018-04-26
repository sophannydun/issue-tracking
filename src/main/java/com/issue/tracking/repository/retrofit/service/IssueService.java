package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Issue;
import com.issue.tracking.model.Role;

public interface IssueService {
	public List<Issue> getAllIssues();
	
	public Boolean createIssue(Issue issue);
}
