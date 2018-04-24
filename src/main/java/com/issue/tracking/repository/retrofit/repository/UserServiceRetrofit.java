package com.issue.tracking.repository.retrofit.repository;

import java.util.List;


import com.issue.tracking.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface UserServiceRetrofit {
	@GET("/api/user")
	Call<List<User>> getAllUsers();
	
	@GET("/api/user/{userId}")
	Call <User> findUserById(@Path(value = "userId") Integer userId);
	
	@GET("/api/user/userDetail")
	Call<User> loadUserByUsername(@Query("username") String username);
	
}
