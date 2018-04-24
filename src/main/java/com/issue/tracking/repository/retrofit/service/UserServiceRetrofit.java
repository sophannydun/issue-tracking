package com.issue.tracking.repository.retrofit.service;

import java.util.List;
import com.issue.tracking.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserServiceRetrofit {
	@GET("/api/user")
	Call<List<User>> getAllUsers();
	
	@GET("/api/user/{userId}")
	Call <User> findUserById(@Path(value = "userId") Integer userId);
	
	@POST("/api/user")
	Call <Boolean> createUser (@Body User user);
	
	@DELETE("/api/user/remove")
	Call <Boolean> deleteUserByUserId(@Query("userId") Integer userId );
	
	@PUT("/api/user")
	Call <Boolean> updateUserByUserId (@Body User user);
}
