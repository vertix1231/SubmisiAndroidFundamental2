package com.dicoding.android.fundamental.githubuserapp.service;

import com.dicoding.android.fundamental.githubuserapp.pojo.Pojogithub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    @GET("/users")
    @Headers("Authorization: token 51d73a3ceeac29f861a0c8b4895dd9b51ebd9799")
    public Call<List<Pojogithub>> getUsers(@Query("per_page") int perPage, @Query("page") int page);

    @GET("/users/{username}")
    @Headers("Authorization: token 51d73a3ceeac29f861a0c8b4895dd9b51ebd9799")
    public Call<Pojogithub> getUser(@Path("username") String username);
}
