package com.liu.day07_work.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    @NotNull
    @Override
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        return (T) new MyViewModel(new MyRepository(new MyModel()));
    }
}
