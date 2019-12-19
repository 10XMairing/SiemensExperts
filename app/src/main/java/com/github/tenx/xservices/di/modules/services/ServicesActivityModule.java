package com.github.tenx.xservices.di.modules.services;

import android.content.Context;

import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.xservices.base.ViewModelFactory;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.di.scopes.ActivityContext;
import com.github.tenx.xservices.di.scopes.PerActivity;
import com.github.tenx.xservices.ui.Services.ServicesActivity;
import com.github.tenx.xservices.ui.Services.ServicesViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ServicesActivityModule {
    @Provides
    @PerActivity
    @ActivityContext
    static Context provideServiceActivityModule(ServicesActivity activity){
        return activity;
    }


    @Provides
    static ServicesViewModel provideServiceViewModel(ServicesActivity servicesActivity , AppDataManager appDataManager){
        ViewModelFactory<ServicesViewModel> factory = new ViewModelFactory<>(new ServicesViewModel(appDataManager));
        return ViewModelProviders.of(servicesActivity, factory).get(ServicesViewModel.class);
    }
}
