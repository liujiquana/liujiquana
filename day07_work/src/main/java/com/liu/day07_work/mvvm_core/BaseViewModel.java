package com.liu.day07_work.mvvm_core;

import androidx.lifecycle.ViewModel;

public
class BaseViewModel<R extends BaseReposition> extends ViewModel {
    protected R mReposition;

    public BaseViewModel(R mReposition) {
        this.mReposition = mReposition;
    }
}
