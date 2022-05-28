package com.liu.day07_work.mvvm_core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public abstract
class BaseFragment<VM extends BaseViewModel,DB extends ViewDataBinding> extends Fragment {
    protected DB mBinding;
    protected VM mViewModel;
    protected abstract int BindLayout();
    protected abstract VM createViewModel();
    protected abstract void initData();
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(BindLayout(),container,false);
        mBinding = DataBindingUtil.bind(view);
        mViewModel = createViewModel();
        initData();
        return mBinding.getRoot();
    }
}
