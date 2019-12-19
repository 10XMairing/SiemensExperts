package com.github.tenx.xservices.di.modules.business.businessMain;

import android.content.Context;

import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.xservices.base.ViewModelFactory;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.di.scopes.ActivityContext;
import com.github.tenx.xservices.di.scopes.PerActivity;
import com.github.tenx.xservices.ui.business.main.BusinessMainActivity;
import com.github.tenx.xservices.ui.business.main.BusinessMainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BusinessMainActivityModule {

    @Provides
    @PerActivity
    @ActivityContext
    static Context provideBusinessMainActivit(BusinessMainActivity activity){
        return activity;
    }


    @Provides
    static BusinessMainViewModel provideBusinessMainViewModel(BusinessMainActivity mainActivity , AppDataManager appDataManager){
        ViewModelFactory<BusinessMainViewModel> factory = new ViewModelFactory<>(new BusinessMainViewModel(appDataManager));
        return ViewModelProviders.of(mainActivity, factory).get(BusinessMainViewModel.class);
    }

}
