package com.liu.day07_work;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.ToastUtils;
import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.UserBean;
import com.liu.day07_work.databinding.ActivityLoginBinding;
import com.liu.day07_work.mvvm_core.BaseActivity;
import com.liu.day07_work.vm.MyViewModel;
import com.liu.day07_work.vm.MyViewModelFactory;

public
class LoginActivity extends BaseActivity<MyViewModel, ActivityLoginBinding> {
    @Override
    protected int BindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected MyViewModel createViewModel() {
        return new ViewModelProvider(this,new MyViewModelFactory()).get(MyViewModel.class);
    }
    @Override
    protected void initData() {
        // 登录
        mBinding.loginBtn.setOnClickListener( v -> {
            if (mBinding.loginUsername.getText().toString().isEmpty()){
                ToastUtils.showShort("用户名不能为空");
            }else if (mBinding.loginPassword.getText().toString().isEmpty()){
                ToastUtils.showShort("密码不能为空");
            }else {
                mViewModel.getLogin(
                        mBinding.loginUsername.getText().toString(),
                        mBinding.loginPassword.getText().toString()).observe(this, new Observer<ApiResponse<UserBean>>() {
                    @Override
                    public void onChanged(ApiResponse<UserBean> userBeanApiResponse) {
                        if (userBeanApiResponse.getMsg().equals("登录失败!") || userBeanApiResponse.getMsg().equals("用户不存在")){
                            ToastUtils.showShort("请核对信息后再次进行登录!!");
                            return;
                        }else {
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });

        //  没有账号 去注册
        mBinding.goRegister.setOnClickListener( v -> {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
    }
}
