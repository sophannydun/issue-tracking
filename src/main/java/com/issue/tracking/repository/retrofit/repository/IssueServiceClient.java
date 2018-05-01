package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.Issue;
import com.issue.tracking.model.IssueApproval;
import com.issue.tracking.model.Role;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IssueServiceClient {
	@GET("/api/issues")
	Call<List<Issue>> getAllIssues();
	
	@GET("/api/issue/{issueId}")
	Call <Issue> findIssueById(@Path(value = "issueId")  Integer issueId);
	@POST("/api/issues")
	Call<Boolean> createIssue(@Body Issue issue);
	
	@PUT("/api/lineapprove")
	Call <Boolean> lineManagerApproval(@Body Issue issue,@Body IssueApproval issueApproval);
}
