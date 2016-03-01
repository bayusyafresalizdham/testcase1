package com.namagz.testcase1.rest;


import com.namagz.testcase1.Model.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Teknorial on 06/02/2016.
 */
public interface RestApi {

    @GET("gists/public")
    Call<List<Models>> getData();
}