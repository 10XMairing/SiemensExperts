package com.github.tenx.xservices.di.modules.function;

import android.content.Context;

import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.xservices.base.ViewModelFactory;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.di.scopes.ActivityContext;
import com.github.tenx.xservices.di.scopes.PerActivity;
import com.github.tenx.xservices.ui.Function.FunctionActivity;
import com.github.tenx.xservices.ui.Function.FunctionViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract  class FunctionActivityModule {

    @Provides
    @PerActivity
    @ActivityContext
    static Context provideFunctionActivityModule(FunctionActivity activity){
        return activity;
    }


    @Provides
    static FunctionViewModel provideFunctionViewModel(FunctionActivity functionActivity , AppDataManager appDataManager){
        ViewModelFactory<FunctionViewModel> factory = new ViewModelFactory<>(new FunctionViewModel(appDataManager));
        return ViewModelProviders.of(functionActivity, factory).get(FunctionViewModel.class);
    }
}
