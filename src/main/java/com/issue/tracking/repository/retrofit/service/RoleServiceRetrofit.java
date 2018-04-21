package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Role;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
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
	@GET("/api/roles/{id}")
	Call<Role> findRoleById(@Path("id") Integer id);
	
	@POST("/api/roles")
	Call<Boolean> createRole(@Body Role role);
	
	@PUT("/api/roles")
	Call<Boolean> updateRoleById(@Body Role role);
	
	//calling API @PathVariable in Retrofit use @Path
	@DELETE("/api/roles/remove/{id}")
	Call<Boolean> removeRoleById(@Path("id")Integer id);
	
	//calling API @RequestParam in Retrofit use @Query
	/*@DELETE("/api/roles/remove")
	Call<Boolean> removeRoleById(@Query("id")Integer id);*/
}
