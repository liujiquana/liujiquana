package com.liu.day07_work;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.fhz.utilsfhz.ApiResponse;
import com.liu.day07_work.bean.UserBean;
import com.liu.day07_work.databinding.ActivityRegisterBinding;
import com.liu.day07_work.mvvm_core.BaseActivity;
import com.liu.day07_work.vm.MyViewModel;
import com.liu.day07_work.vm.MyViewModelFactory;

public class RegisterActivity extends BaseActivity<MyViewModel, ActivityRegisterBinding> {
    @Override
    protected int BindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected MyViewModel createViewModel() {
        return  new ViewModelProvider(this, new MyViewModelFactory()).get(MyViewModel.class);
    }

    @Override
    protected void initData() {

        mBinding.loginBtn.setOnClickListener(v -> {
            String nickname = mBinding.registerUsername.getText().toString();
            String password = mBinding.registerUsername.getText().toString();
            String phoneNumber = mBinding.registerUsername.getText().toString();
            if (nickname.isEmpty()){
                ToastUtils.showShort("用户名不能为空");
            }else if (password.isEmpty()){
                ToastUtils.showShort("密码不能为空");
            }else if (phoneNumber.isEmpty()){
                ToastUtils.showShort("手机号不能为空");
            }else {
               UserBean userBean = new UserBean(nickname,password,phoneNumber);
                mViewModel.getRegister(userBean).observe(this, new Observer<ApiResponse<UserBean>>() {
                    @Override
                    public void onChanged(ApiResponse<UserBean> userBeanApiResponse) {
                        LogUtils.d(""+userBeanApiResponse.getMsg());
                        LogUtils.d(""+userBeanApiResponse.getCode());
                        LogUtils.d(""+userBeanApiResponse.getData().getNickname());
                        ToastUtils.showShort(""+userBeanApiResponse.getMsg());
                        if (userBeanApiResponse.getCode() == 0){
                            ToastUtils.showShort("注册成功");
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }else {
                            ToastUtils.showShort("注册失败");
                            mBinding.registerUsername.setText("");
                            mBinding.registerPhoneNumber.setText("");
                            mBinding.registerPwd.setText("");
                        }
                    }
                });
            }
        });



    }
}