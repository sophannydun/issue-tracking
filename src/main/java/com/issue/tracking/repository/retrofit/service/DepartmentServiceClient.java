package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Department;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DepartmentServiceClient {
	@GET("/api/departments")
	Call<List<Department>> getAllDepartment();
}
