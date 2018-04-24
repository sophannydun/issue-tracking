package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.repository.UserServiceRetrofit;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	private UserServiceRetrofit userServiceRetrofit;

	@Autowired
	public UserDetailServiceImp(Retrofit retrofit) {
		this.userServiceRetrofit = retrofit.create(UserServiceRetrofit.class);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Response<User> jsonUsers;
		User user=null;
		try {
			jsonUsers = userServiceRetrofit.loadUserByUsername(username).execute();
			 user = jsonUsers.body();
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
}
