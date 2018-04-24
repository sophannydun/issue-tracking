package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Department;

public interface DepartmentService {
	public List<Department> getAllDepartment();

	public Department findDepartmentById(Integer departmentId);

	public Boolean createDepartment(Department department);

	public Boolean removeDepartmentById(Integer departmentId);

	public Boolean updateDepartmentById(Department department);
}
