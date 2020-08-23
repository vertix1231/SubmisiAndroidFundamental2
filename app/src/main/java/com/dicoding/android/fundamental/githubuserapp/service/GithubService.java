package com.dicoding.android.fundamental.githubuserapp.service;

import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    @GET("/users")
    public Call<List<Pojogithub>> getUsers(@Query("per_page") int perPage, @Query("page") int page);

    @GET("/users/{username}")
    public Call<Pojogithub> getUser(@Path("username") String username);
}
