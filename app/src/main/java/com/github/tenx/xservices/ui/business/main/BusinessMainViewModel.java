package com.github.tenx.xservices.ui.business.main;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.data.models.auth.UpdateExpertBody;

import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import timber.log.Timber;

public class BusinessMainViewModel extends BaseViewModel implements BusinessMainViewModelHelper {


    private AppDataManager appDataManager;

    public BusinessMainViewModel(AppDataManager appDataManager) {
        super(appDataManager);
        this.appDataManager = appDataManager;
    }

    public String getString(){
        return "i am a manuh . Do you understand me??";
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
