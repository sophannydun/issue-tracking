package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.Department;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class DepartmentServiceImp implements DepartmentService {

	private DepartmentServiceClient departmentServiceClient;

	@Autowired
	public DepartmentServiceImp(Retrofit retrofit) {
		
		this.departmentServiceClient = retrofit.create(DepartmentServiceClient.class);
		
	}

	@Override
	public List<Department> getAllDepartment() {
		Response<List<Department>> jsonDepartment = null;
		try {
			jsonDepartment = this.departmentServiceClient.getAllDepartment().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Department> departments = jsonDepartment.body();
		return departments;
	}

}
