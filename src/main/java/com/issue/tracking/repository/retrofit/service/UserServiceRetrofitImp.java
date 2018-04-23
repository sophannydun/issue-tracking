package com.issue.tracking.repository.retrofit.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracking.model.User;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class UserServiceRetrofitImp {
	private UserServiceRetrofit userServiceRetrofit;

	@Autowired
	public UserServiceRetrofitImp(Retrofit retrofit) {
		this.userServiceRetrofit = retrofit.create(UserServiceRetrofit.class);
	}
	public List<User> getAllUsers() throws IOException{
		Response<List<User>> jsonUser = userServiceRetrofit.getAllUsers().execute();
		List<User> users=jsonUser.body();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
	}
	public User findUserById(Integer userId) throws IOException{
			Response<User> jsonUser=userServiceRetrofit.findUserById(userId).execute();
			User user=jsonUser.body();
			System.out.println(jsonUser.body());
		return user;
	}
	public Boolean createUser(User user) throws IOException{
		Response<Boolean> jsonUser=userServiceRetrofit.createUser(user).execute();
		Boolean b=jsonUser.body();
		System.out.println(jsonUser.body());
	return b;
}
}
