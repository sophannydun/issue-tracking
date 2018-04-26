package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.Branch;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BranchServiceRetrofit {

	@GET("/api/branch")
	Call <List<Branch>> findAllBranch();

	@GET("/api/branch/{branchId}")
	Call <Branch> findBranchById(@Path("branchId") Integer branchId);
	
	@POST("/api/branch/add")
	Call <Boolean> createBranch(@Body Branch branch);
	
	@PUT("/api/branch/update")
	Call <Boolean> updateBranchById(@Body Branch branch);

	@DELETE("/api/branch/remove/{branchId}")
	Call <Boolean> removeBranchById(@Path("branchId") Integer branchId);
	
 }
