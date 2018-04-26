package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.Branch;
import com.issue.tracking.repository.retrofit.repository.BranchServiceRetrofit;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class BranchServiceImp implements BranchService {

	private BranchServiceRetrofit branchServiceRetrofit;

	@Autowired
	public BranchServiceImp(Retrofit retrofit) {

		branchServiceRetrofit = retrofit.create(BranchServiceRetrofit.class);
	}

	@Override
	public List<Branch> findAllBranch() {
		try {
			Response<List<Branch>> jsonBranches = branchServiceRetrofit.findAllBranch().execute();
			List<Branch> branches = jsonBranches.body();
			System.out.println("client service branches json-> " + jsonBranches.body());
			return branches;
		} catch (IOException e) {
			System.out.println("Cannot find All Branch!!!");
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Branch findBranchById(Integer branchId) {
		Response <Branch> jsonBranch=null;
		Branch branch=null;
		if(branchId==null){
			return new Branch();
		}
		try {
			jsonBranch=branchServiceRetrofit.findBranchById(branchId).execute();
			branch=jsonBranch.body();
		} catch (IOException e) {
			System.out.println("Cannot find Branch By ID!!!");
			e.printStackTrace();
		}
		return branch;
	}

	@Override
	public Boolean createBranch(Branch branch) {
		boolean createStatus=false;
		Response<Boolean> jsonCreate;
		if(branch==null){
			return false;
		}
		try {
			jsonCreate=branchServiceRetrofit.createBranch(branch).execute();
			createStatus=jsonCreate.body();
		} catch (IOException e) {
			System.out.println("Create Branch Failed!!!");
			e.printStackTrace();
		}
		return createStatus;
	}

	@Override
	public Boolean removeBranchById(Integer branchId) {
		boolean removeStatus=false;
		Response<Boolean> jsonRemove;
		if(branchId==null){
			return false;
		}
		try {
			jsonRemove=branchServiceRetrofit.removeBranchById(branchId).execute();
			removeStatus=jsonRemove.body();
		} catch (IOException e) {
			System.out.println("Remove Branch Failed!!!");
			e.printStackTrace();
		}
		return removeStatus;
	}

	@Override
	public Boolean updateBranchById(Branch branch) {
		boolean updateStatus=false;
		Response<Boolean> jsonUpdate;
		if(branch==null){
			return false;
		}
		try {
			jsonUpdate=branchServiceRetrofit.updateBranchById(branch).execute();
			updateStatus=jsonUpdate.body();
		} catch (IOException e) {
			System.out.println("Update Branch Failed!!!");
			e.printStackTrace();
		}
		return updateStatus;
		
	}

}
