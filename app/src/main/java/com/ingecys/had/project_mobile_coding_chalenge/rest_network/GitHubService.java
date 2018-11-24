package com.ingecys.had.project_mobile_coding_chalenge.rest_network;

import com.ingecys.had.project_mobile_coding_chalenge.model.Repos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GitHubService {


    @GET("repositories?sort=stars&order=desc?")
    Call<Repos> getItemsRepository(@Query("q") String date, @Query("page") String page);


}
