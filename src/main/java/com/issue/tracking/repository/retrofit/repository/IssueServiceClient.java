package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.Issue;
import com.issue.tracking.model.Role;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IssueServiceClient {
	@GET("/api/issues")
	Call<List<Issue>> getAllIssues();
	
	@POST("/api/issues")
	Call<Boolean> createIssue(@Body Issue issue);
}
