package com.liu.day07_work.vm;

import androidx.lifecycle.LiveData;

import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.ShopBean;
import com.liu.day07_work.bean.UserBean;
import com.liu.day07_work.mvvm_core.BaseViewModel;

import java.util.List;

public
class MyViewModel extends BaseViewModel<MyRepository> {
    public MyViewModel(MyRepository mReposition) {
        super(mReposition);
    }

    public LiveData<ApiResponse<UserBean>> getLogin(String username, String pwd){
        return mReposition.getLogin(username, pwd);
    }

    public LiveData<ApiResponse<UserBean>> getRegister(UserBean bean){
        return mReposition.getRegister(bean);
    }
    public LiveData<ApiResponse<List<ShopBean>>> getShopBean(){
        return mReposition.getShopBean();
    }
}
