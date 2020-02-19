package com.example.myapplication;

import com.example.myapplication.NewApi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TimesApi {

    @GET("topstories/v2/{section}.json")
    Call<NewApi> getNewApi(@Path("section") String section, @Query("api-key") String apiKey);
}


