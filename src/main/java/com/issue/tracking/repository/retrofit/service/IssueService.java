package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Issue;
import com.issue.tracking.model.IssueApproval;
import com.issue.tracking.model.Role;

public interface IssueService {
	public List<Issue> getAllIssues();
	
	public Issue findIssueById(Integer issueId);
	public Boolean createIssue(Issue issue);
	public Boolean lineManagerApproval(Issue issue,IssueApproval issueApproval);
}
