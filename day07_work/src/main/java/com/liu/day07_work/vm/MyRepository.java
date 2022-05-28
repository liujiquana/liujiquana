package com.liu.day07_work.vm;

import androidx.lifecycle.LiveData;

import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.ShopBean;
import com.liu.day07_work.bean.UserBean;
import com.liu.day07_work.mvvm_core.BaseReposition;

import java.util.List;

public
class MyRepository extends BaseReposition<MyModel> {

    public MyRepository(MyModel mModel) {
        super(mModel);
    }

    public LiveData<ApiResponse<UserBean>> getLogin(String username, String pwd){
       return mModel.getLogin(username, pwd);
    }
    public LiveData<ApiResponse<UserBean>> getRegister(UserBean user){
        return mModel.getRegister(user);
    }
    public LiveData<ApiResponse<List<ShopBean>>> getShopBean(){
        return mModel.getShopBean();
    }
}
