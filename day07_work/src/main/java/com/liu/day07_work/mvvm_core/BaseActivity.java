package com.liu.day07_work.mvvm_core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract
class BaseActivity<VM extends BaseViewModel,DB extends ViewDataBinding> extends AppCompatActivity {

    protected DB mBinding;
    protected VM mViewModel;
    protected abstract int BindLayout();
    protected abstract VM createViewModel();
    protected abstract void initData();
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, BindLayout());
        mViewModel = createViewModel();
        initData();
    }

}
