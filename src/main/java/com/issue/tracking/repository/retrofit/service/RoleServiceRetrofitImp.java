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
	public List<Role> getAllRoles() throws IOException {
		Response<List<Role>> jsonRole = roleServiceRetrofit.getAllRoles().execute();
		List<Role> roles = jsonRole.body();
		for (Role role : roles) {
			System.out.println(role.toString());
		}
		return roles;
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
	public Role findRoleById(Integer id) throws IOException {
		Response<Role> jsonRole= roleServiceRetrofit.findRoleById(id).execute();
		Role role=jsonRole.body();
		if(role==null){
			return new Role();
		}
		return role;
	}

	public Boolean createRole(Role role) throws IOException{
		Response<Boolean> jsonRole = roleServiceRetrofit.createRole(role).execute();
		Boolean status=false;
		System.out.println("B4 Create=" + status);
		status=jsonRole.body();
		System.out.println("jsonRole= " + jsonRole.body().toString());
		System.out.println("After assign=" + status);
		return status;
	}
	public Boolean updateRoleById(Role role) throws IOException{
		Response<Boolean> jsonRole = roleServiceRetrofit.updateRoleById(role).execute();
		Boolean status=false;
		System.out.println("B4 update=" + status);
		status=jsonRole.body();
		System.out.println("jsonRole= " + jsonRole.body().toString());
		System.out.println("After assign=" + status);
		return status;
	}
	public Boolean removeRoleById(Integer id) throws IOException{
		Response<Boolean> jsonRole = roleServiceRetrofit.removeRoleById(id).execute();
		Boolean status=false;
		System.out.println("B4 remove=" + status);
		status=jsonRole.body();
		System.out.println("jsonRole= " + jsonRole.body().toString());
		System.out.println("After assign=" + status);
		return status;
	}
}
