package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.IssueApproval;

public interface UserIssueService {
	public List<IssueApproval> findAllIssueApproval();

	public Boolean createIssueApproval(IssueApproval issueApproval);
}
