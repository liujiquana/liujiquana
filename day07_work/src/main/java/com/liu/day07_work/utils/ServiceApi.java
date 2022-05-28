package com.liu.day07_work.utils;

import androidx.lifecycle.LiveData;

import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.ShopBean;
import com.liu.day07_work.bean.UserBean;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public
interface ServiceApi {

    @POST("user/register")
    LiveData<ApiResponse<UserBean>> register(@Body UserBean userBean);

    @POST("user/login")
    @FormUrlEncoded
    LiveData<ApiResponse<UserBean>> login(@Field("nickname") String nickname, @Field("password") String password);

    @GET("/attention/all")
    LiveData<ApiResponse<List<ShopBean>>> getShopBean();

}
