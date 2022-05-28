package com.liu.day07_work;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.ShopBean;
import com.liu.day07_work.databinding.ActivityHomeBinding;
import com.liu.day07_work.mvvm_core.BaseActivity;
import com.liu.day07_work.vm.MyViewModel;
import com.liu.day07_work.vm.MyViewModelFactory;

import java.util.List;

public
class HomeActivity extends BaseActivity<MyViewModel, ActivityHomeBinding> {
    @Override
    protected int BindLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected MyViewModel createViewModel() {
        return new ViewModelProvider(this,new MyViewModelFactory()).get(MyViewModel.class);
    }

    @Override
    protected void initData() {
        mViewModel.getShopBean().observe(this, new Observer<ApiResponse<List<ShopBean>>>() {
            @Override
            public void onChanged(ApiResponse<List<ShopBean>> listApiResponse) {

            }
        });
    }
}
