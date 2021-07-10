package com.example.safecity.ui.login;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("user/login")
    Call<LoginResult> executeLogin(@Body HashMap<String,String> map);

    @POST("user/register")
    Call<Void> executeSignup(@Body HashMap<String,String> map);

    @POST("user/request_new_password")
    Call<LoginResult> executeRequest(@Body HashMap<String,String> map);

    @POST("user/new_password")
    Call<Void> executeNewPassword(@Body HashMap<String,String> map);
}