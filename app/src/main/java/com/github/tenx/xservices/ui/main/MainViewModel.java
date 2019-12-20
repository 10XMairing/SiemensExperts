package com.github.tenx.xservices.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.data.models.auth.UpdateExpertBody;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import timber.log.Timber;

public class MainViewModel  extends BaseViewModel implements MainViewModelHelper {
    private AppDataManager appDataManager;

    private static final String TAG = "MainViewModel";



    public MainViewModel(AppDataManager appDataManager) {
        super(appDataManager);
        this.appDataManager = appDataManager;
    }

    public void uploadToken(String token){
        UpdateExpertBody data = new UpdateExpertBody();
        data.setToken(token);
        appDataManager.updateExpertprofile(data).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Response<JSONObject>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<JSONObject> response) {
                Timber.i("Token upload Response status : "+response.code());
                Timber.i("Token upload Response  : "+response.message());
            }

            @Override
            public void onError(Throwable e) {
                Timber.e("error token : upload : "+e.toString());
            }

            @Override
            public void onComplete()    {
                Timber.d("Completed");
            }
        });
    }





}
