package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Issue;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IssueServiceClient {
	@GET("/api/issues")
	Call<List<Issue>> getAllIssues();
}
