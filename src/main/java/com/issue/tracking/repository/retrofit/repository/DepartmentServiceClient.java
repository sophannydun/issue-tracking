package com.issue.tracking.repository.retrofit.repository;

import java.util.List;

import com.issue.tracking.model.Department;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartmentServiceClient {
	@GET("/api/departments")
	Call<List<Department>> getAllDepartment();
	
	@GET("/api/department/{departmentId}")
	Call <Department> findDepartmentById(@Path("departmentId") Integer departmentId);
	
	@POST("/api/department/add")
	Call<Boolean> createDepartment(@Body Department department);
	
	@DELETE("/api/department/remove/{departmentId}")
	Call<Boolean> removeDepartmentById(@Path("departmentId")Integer departmentId);

	@PUT("/api/department/update")
	Call<Boolean> updateDepartmentById(@Body Department department);
}
