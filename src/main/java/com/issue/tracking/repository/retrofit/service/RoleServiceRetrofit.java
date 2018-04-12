package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Role;
import com.issue.tracking.model.RoleCustomResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RoleServiceRetrofit {
	@GET("/api/roles")
	Call<List<Role>> getAllRoles();
	/*
	 * Customize response
	 * 
	 * @GET("/api/roless")
	Call<RoleCustomResponse> getAllRoles();
	*/
	@POST("/api/roles")
	Call<Boolean> createRole(@Body Role role);
}
