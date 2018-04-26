package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import com.issue.tracking.model.Branch;

public interface BranchService {
	public List<Branch> findAllBranch();

	public Branch findBranchById(Integer branchId);

	public Boolean createBranch(Branch branch);

	public Boolean removeBranchById(Integer branchId);

	public Boolean updateBranchById(Branch branch);
}
