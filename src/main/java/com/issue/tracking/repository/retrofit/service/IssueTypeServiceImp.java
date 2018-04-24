package com.issue.tracking.repository.retrofit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.IssueType;
import com.issue.tracking.repository.retrofit.repository.IssueTypeServiceClient;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class IssueTypeServiceImp implements IssueTypeService{

	private IssueTypeServiceClient issueTypeServiceClient;	
	
	@Autowired
	public IssueTypeServiceImp(Retrofit retrofit) {
		
		this.issueTypeServiceClient = retrofit.create(IssueTypeServiceClient.class);
	}

	@Override
	public List<IssueType> getAllIssueType() {
		
		Response<List<IssueType>> jsonIssueType = null;
		try {
			jsonIssueType = this.issueTypeServiceClient.getAllIssueType().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<IssueType> issueTypes = jsonIssueType.body();
		System.out.println(issueTypes);
		return issueTypes;
	}

}
