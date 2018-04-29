package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.IssueApproval;
import com.issue.tracking.repository.retrofit.repository.UserIssueRetrofit;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class UserIssueServiceImp implements UserIssueService {

	private UserIssueRetrofit userIssueRetrofitImp;

	@Autowired
	public UserIssueServiceImp(Retrofit retrofit) {
		userIssueRetrofitImp = retrofit.create(UserIssueRetrofit.class);
	}

	@Override
	public List<IssueApproval> findAllIssueApproval() {
		List<IssueApproval> issuesapprove = null;
		try {
			Response<List<IssueApproval>> jsonissues = userIssueRetrofitImp.findAllIssueApproval().execute();
			issuesapprove = jsonissues.body();
			System.out.println("Client Service All Approved Issue" + issuesapprove);
		} catch (IOException e) {
			System.out.println("API Find All IssueApproval Fail !!!");
			e.printStackTrace();
		}
		return issuesapprove;
	}

	@Override
	public Boolean createIssueApproval(IssueApproval issueApproval) {
		Boolean create = false;
		if (issueApproval == null) {
			return false;
		}
		Response<Boolean> jsonCreate;
		try {
			jsonCreate = userIssueRetrofitImp.createIssueApproval(issueApproval).execute();
			create=jsonCreate.body();
		} catch (IOException e) {
			System.out.println("API Create IssueApproval Fail !!!");
			e.printStackTrace();
		}
		return create;
	}

}
