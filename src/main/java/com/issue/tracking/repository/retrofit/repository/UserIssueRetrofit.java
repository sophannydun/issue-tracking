package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.IssueApproval;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface UserIssueRetrofit {
	
	@GET("/api/issueapproval")
	Call <List<IssueApproval>> findAllIssueApproval();

	@PUT("/api/issueapproval")
	Call <Boolean> createIssueApproval(@Body IssueApproval issueApproval);
}
