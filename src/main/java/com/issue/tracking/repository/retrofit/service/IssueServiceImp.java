package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.Issue;
import com.issue.tracking.repository.retrofit.repository.IssueServiceClient;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class IssueServiceImp implements IssueService {

	private IssueServiceClient IssueServiceClient;
	
	@Autowired
	 public IssueServiceImp(Retrofit retrofit) {

		 this.IssueServiceClient = retrofit.create(IssueServiceClient.class);
		 
	}
	
	@Override
	public List<Issue> getAllIssues() {
		Response<List<Issue>> jsonIssue = null;
		try {
			jsonIssue = this.IssueServiceClient.getAllIssues().execute();
		}catch (IOException e) {
			e.printStackTrace();
		}
		List<Issue> issues = jsonIssue.body();
		
		return issues;
	}

	@Override
	public Boolean createIssue(Issue issue) {
		Response<Boolean> jsonIssue = null;
		Boolean createIssue=false;
		try {
			jsonIssue = this.IssueServiceClient.createIssue(issue).execute();
			createIssue=jsonIssue.body();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Client Service Create issue Status ->" + createIssue );
		return createIssue;
	}

	
}
