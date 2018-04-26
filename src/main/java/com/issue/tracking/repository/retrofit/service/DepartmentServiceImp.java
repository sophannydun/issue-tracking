package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.issue.tracking.model.Department;

import com.issue.tracking.repository.retrofit.repository.DepartmentServiceClient;

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
		List<Department> departments =null;
		try {
			jsonDepartment = this.departmentServiceClient.getAllDepartment().execute();
			departments= jsonDepartment.body();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public Department findDepartmentById(Integer departmentId) {
		Response<Department> jsonDepartment;
		Department department = null;
		try {
			jsonDepartment = departmentServiceClient.findDepartmentById(departmentId).execute();
			department = jsonDepartment.body();
		} catch (Exception e) {
			System.out.println(" Department not Found !!!" + departmentId);
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public Boolean createDepartment(Department department) {
		Boolean create = false;
		try {
			Response<Boolean> jsonCreate = departmentServiceClient.createDepartment(department).execute();
			create = jsonCreate.body();
		} catch (IOException e) {
			System.out.println(create + " Create Department Failed !!!" + department);
			e.printStackTrace();
		}
		return create;
	}

	@Override
	public Boolean removeDepartmentById(Integer departmentId) {
		Boolean remove = false;
		try {
			Response<Boolean> jsonRemove = departmentServiceClient.removeDepartmentById(departmentId).execute();
			remove = jsonRemove.body();
		} catch (IOException e) {
			System.out.println(remove + " Remove Department Failed !!!" + departmentId);
			e.printStackTrace();
		}
		return remove;
	}

	@Override
	public Boolean updateDepartmentById(Department department) {
		Boolean update = false;
		try {
			Response<Boolean> jsonUpdate = departmentServiceClient.updateDepartmentById(department).execute();
			update = jsonUpdate.body();
		} catch (IOException e) {
			System.out.println(update + " Update Department Failed !!!" + department);
			e.printStackTrace();
		}
		return update;
	}

}
