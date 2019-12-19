package com.github.tenx.xservices.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.data.models.auth.LoginBody;
import com.github.tenx.xservices.data.models.auth.RegistrationBody;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseExpert;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AuthViewModel extends BaseViewModel implements AuthViewModelHelper {

    private AppDataManager appDataManager;

    private static final String TAG = "AuthViewModel";

    //LiveData declarations
    MutableLiveData<Boolean> registrationResponseExpert;
    MutableLiveData<Boolean> loginResponseExpert;

    MutableLiveData<Boolean> registrationResponseService;
    MutableLiveData<Boolean> loginResponseService;


    //LiveData Getters

    public LiveData<Boolean> getRegistrationResponseExpert(){
        if (registrationResponseExpert==null)
            registrationResponseExpert = new MutableLiveData<>();
        return registrationResponseExpert;
    }

    public LiveData<Boolean> getLoginResponseExpert(){
        if (loginResponseExpert==null)
            loginResponseExpert = new MutableLiveData<>();
        return loginResponseExpert;
    }
    public LiveData<Boolean> getRegistrationResponseService(){
        if (registrationResponseService==null)
            registrationResponseService = new MutableLiveData<>();
        return registrationResponseService;
    }

    public LiveData<Boolean> getLoginResponseService(){
        if (loginResponseService==null)
            loginResponseService = new MutableLiveData<>();
        return loginResponseService;
    }








    public AuthViewModel(AppDataManager dataManager) {
        super(dataManager);
        this.appDataManager = dataManager;

    }


    public String getString(){
        return "i am a manuh . Do you understand Goru 36??";
    }

    public void setAuthToken(String token){
        appDataManager.setAccessToken(token);
    }

    public String getAuthToken(){
        return appDataManager.getAccessToken();
    }

    public void setUserId(String id){
        appDataManager.setUserId(id);
    }

    public String getUserId(){
        return appDataManager.getUserId();
    }


    public void setUserEmail(String email){
        appDataManager.setEmail(email);
    }

    public String getUserEmail(){
        return appDataManager.getEmail();
    }


    //TODO check this
    public void registerExpert(RegistrationBody body){
        if (registrationResponseExpert==null)
            registrationResponseExpert = new MutableLiveData<>();

        appDataManager.registerExpert(body).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()).subscribe(new Observer<Response<RegistrationResponseExpert>>() {
            @Override
            public void onSubscribe(Disposable d) {
                getCompositeDisposable().add(d);
            }

            @Override
            public void onNext(Response<RegistrationResponseExpert> registrationResponseResponse) {

                if (registrationResponseResponse.code()==200){
                    setAuthToken(registrationResponseResponse.body().getToken());
                    setUserEmail(registrationResponseResponse.body().getmData().getEmail());
                    setUserId(registrationResponseResponse.body().getmData().getId());

                    registrationResponseExpert.setValue(true);

                }else{
                    Log.d(TAG, "onNext: " + registrationResponseResponse.code());
                    Log.d(TAG, "onNext: Error occured.. ");
                    registrationResponseExpert.setValue(false);
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ",e );
                registrationResponseExpert.setValue(false);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Registration Complete." );
            }
        });


    }

    public void loginExpert(LoginBody loginBody){

        if (loginResponseExpert==null)
            loginResponseExpert = new MutableLiveData<>();

        appDataManager.loginExpert(loginBody).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Response<RegistrationResponseExpert>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(Response<RegistrationResponseExpert> registrationResponseResponse) {
                        if (registrationResponseResponse.code()==200){

                            setAuthToken(registrationResponseResponse.body().getToken());

                            loginResponseExpert.setValue(true);


                        }else{
                            loginResponseExpert.setValue(false);
                            Log.d(TAG, "onNext: code::: " + registrationResponseResponse.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginResponseExpert.setValue(false);
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: LoginCompleted");
                    }
                });
    }

    public void registerService(RegistrationBody body){
        if (registrationResponseService==null)
            registrationResponseService = new MutableLiveData<>();

        appDataManager.registerService(body).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()).subscribe(new Observer<Response<RegistrationResponseService>>() {
            @Override
            public void onSubscribe(Disposable d) {
                getCompositeDisposable().add(d);
            }

            @Override
            public void onNext(Response<RegistrationResponseService> registrationResponseResponse) {

                if (registrationResponseResponse.code()==200){
                    setAuthToken(registrationResponseResponse.body().getToken());
                    setUserEmail(registrationResponseResponse.body().getmData().getEmail());
                    setUserId(registrationResponseResponse.body().getmData().getId());

                    registrationResponseService.setValue(true);

                }else{
                    Log.d(TAG, "onNext: " + registrationResponseResponse.code());
                    Log.d(TAG, "onNext: Error occured.. ");
                    registrationResponseService.setValue(false);
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ",e );
                registrationResponseService.setValue(false);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Registration Complete." );
            }
        });


    }

    public void loginService(LoginBody loginBody){

        if (loginResponseService==null)
            loginResponseService = new MutableLiveData<>();

        appDataManager.loginService(loginBody).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Response<RegistrationResponseService>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(Response<RegistrationResponseService> registrationResponseResponse) {
                        if (registrationResponseResponse.code()==200){

                            setAuthToken(registrationResponseResponse.body().getToken());
                            setUserEmail(registrationResponseResponse.body().getmData().getEmail());
                            setUserId(registrationResponseResponse.body().getmData().getId());

                            loginResponseService.setValue(true);


                        }else{
                            loginResponseService.setValue(false);
                            Log.d(TAG, "onNext: code::: " + registrationResponseResponse.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginResponseService.setValue(false);
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: LoginCompleted");
                    }
                });
    }




}
