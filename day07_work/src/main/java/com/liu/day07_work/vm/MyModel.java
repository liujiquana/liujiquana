package com.liu.day07_work.vm;

import androidx.lifecycle.LiveData;

import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.ShopBean;
import com.liu.day07_work.bean.UserBean;
import com.liu.day07_work.mvvm_core.IModel;
import com.liu.day07_work.utils.RetrofitManager;
import com.liu.day07_work.utils.ServiceApi;

import java.util.List;


public
class MyModel implements IModel {

    public LiveData<ApiResponse<UserBean>> getLogin(String nickname, String password){
        return RetrofitManager.getInstance()
                .getRetrofit()
                .create(ServiceApi.class)
                .login(nickname, password);
    }

    public LiveData<ApiResponse<UserBean>> getRegister(UserBean userBean){
        return RetrofitManager.getInstance()
                .getRetrofit()
                .create(ServiceApi.class)
                .register(userBean);
    }

    public LiveData<ApiResponse<List<ShopBean>>> getShopBean(){
        return RetrofitManager.getInstance()
                .getRetrofit()
                .create(ServiceApi.class)
                .getShopBean();
    }


}
