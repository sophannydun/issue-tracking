package com.issue.tracking.repository.retrofit.service;

import java.util.List;
import com.issue.tracking.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserServiceRetrofit {
	@GET("/api/user")
	Call<List<User>> getAllUsers();
	
	@GET("/api/user/{userId}")
	Call <User> findUserById(@Path(value = "userId") Integer userId);
	
	@POST("/api/user")
	Call <Boolean> createUser (@Body User user);
}
