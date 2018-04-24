package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.IssueType;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IssueTypeServiceClient {
	@GET("/api/issueType")
	Call<List<IssueType>> getAllIssueType();
}
