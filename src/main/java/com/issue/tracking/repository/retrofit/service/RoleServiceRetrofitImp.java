package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.Role;
import com.issue.tracking.model.RoleCustomResponse;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class RoleServiceRetrofitImp {

	private RoleServiceRetrofit roleServiceRetrofit;

	@Autowired
	public RoleServiceRetrofitImp(Retrofit retrofit) {
		roleServiceRetrofit = retrofit.create(RoleServiceRetrofit.class);
	}

	
	/* Normal API response */
	public void getAllRoles() throws IOException {
		Response<List<Role>> jsonRole = roleServiceRetrofit.getAllRoles().execute();
		List<Role> roles = jsonRole.body();
		for (Role role : roles) {
			System.out.println(role.toString());
		}
		
		
		
		
		
		
		
		// System.out.println(roles);
		/*
		 * return array jsonObjec Response<JsonElement>
		 * jsonRole=roleServiceRetrofit.getAllRoles().execute();
		 * System.out.println(jsonRole.body());
		 * System.out.println(jsonRole.body()); }
		 */
		
		/*
		 * Customize response from API
		 * public void getAllRoles() throws IOException {
		 * Response<RoleCustomResponse> jsonRole =
		 * roleServiceRetrofit.getAllRoles().execute(); RoleCustomResponse roles =
		 * jsonRole.body(); System.out.println(roles.toString()); }
		 */
	}
}
