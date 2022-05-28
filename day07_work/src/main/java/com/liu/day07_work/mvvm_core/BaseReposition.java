package com.liu.day07_work.mvvm_core;

public
class BaseReposition<M extends IModel> {
    protected M mModel;
    public BaseReposition(M mModel) {
        this.mModel = mModel;
    }
}
