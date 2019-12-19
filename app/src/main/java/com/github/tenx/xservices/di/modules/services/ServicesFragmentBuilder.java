package com.github.tenx.xservices.di.modules.services;

import com.github.tenx.xservices.ui.Services.equipments.EquipmentsFragment;
import com.github.tenx.xservices.ui.Services.storage.StorageFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ServicesFragmentBuilder {

    @ContributesAndroidInjector(modules = {})
    abstract EquipmentsFragment bindEquipmentsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract StorageFragment bindStorageFragment();


}
