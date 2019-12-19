package com.github.tenx.xservices.di.modules.auth;

import android.content.Context;

import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.xservices.base.ViewModelFactory;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.di.scopes.ActivityContext;
import com.github.tenx.xservices.di.scopes.PerActivity;
import com.github.tenx.xservices.ui.auth.AuthViewModel;
import com.github.tenx.xservices.ui.auth.AuthenticationActivity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AuthActivityModule {


        @Provides
        @PerActivity
        @ActivityContext
        static Context provideAuthActivityModule(AuthenticationActivity activity){
            return activity;
        }


        @Provides
        static AuthViewModel provideAuthViewModel(AuthenticationActivity authenticationActivity , AppDataManager appDataManager){
            ViewModelFactory<AuthViewModel> factory = new ViewModelFactory<>(new AuthViewModel(appDataManager));
            return ViewModelProviders.of(authenticationActivity, factory).get(AuthViewModel.class);
        }
    }



