package com.github.tenx.xservices.base;

import androidx.lifecycle.ViewModel;

import com.github.tenx.xservices.data.AppDataManager;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel{

    private CompositeDisposable compositeDisposable;
    private AppDataManager dataManager;


    public BaseViewModel(AppDataManager dataManager) {
        this.dataManager = dataManager;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        //clearing the rxjaa calls
        compositeDisposable.dispose();
        compositeDisposable.clear();
    }

    public CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }
}
