package com.github.tenx.xservices.di.components;


import android.app.Application;

import com.github.tenx.xservices.di.modules.app.ActivityBuilderModule;
import com.github.tenx.xservices.di.modules.app.AppModule;
import com.github.tenx.xservices.di.modules.app.AppRetrofitModule;
import com.github.tenx.xservices.base.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AppModule.class, AppRetrofitModule.class, ActivityBuilderModule.class, AndroidInjectionModule.class})
@Singleton
public interface AppComponent {

    void inject(BaseApplication application);

    @Component.Builder
    interface  Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
