package com.github.tenx.xservices.ui.business.funcnatilies;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;
import com.github.tenx.xservices.data.models.DefaultResponse;
import com.github.tenx.xservices.data.models.appointments.AppointmentsConfirmationResponse;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;
import com.github.tenx.xservices.data.models.appointments.SingleAppointmentForExpert;
import com.github.tenx.xservices.data.models.products.ProductsBody;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class BusinessFunctionViewModel extends BaseViewModel implements BusinessFunctionViewModelHelper {


    private static final String TAG = "BusinessFunctionViewMod";
    private AppDataManager appDataManager;

    //LiveData declaration
    //Responses
    MutableLiveData<ExpertAppointmentsResponse> expertAppointmentsResonse;
    MutableLiveData<SingleAppointmentForExpert> expertSingleAppointmentResponse;
    MutableLiveData<AppointmentsConfirmationResponse> appointmentsConfirmationResponse;



    //Live Data status
    MutableLiveData<Boolean> statusExpertAppointmentsResponse;
    MutableLiveData<Boolean> statusExpertSingleAppointmentResponse;
    MutableLiveData<Boolean> statusCreateProduct;
    MutableLiveData<Boolean> statusAppointments;

    @Override
    public LiveData<ExpertAppointmentsResponse> getAppointmentsForExperts() {
        if (expertAppointmentsResonse==null)
            expertAppointmentsResonse = new MutableLiveData<>();
        return expertAppointmentsResonse;
    }

    @Override
    public LiveData<SingleAppointmentForExpert> getSingleAppointmentForExpert() {

        if (expertSingleAppointmentResponse==null)
            expertSingleAppointmentResponse = new MutableLiveData<>();
        return expertSingleAppointmentResponse;


    }

    @Override
    public LiveData<Boolean> createNewProduct() {
        if (statusCreateProduct==null)
            statusCreateProduct = new MutableLiveData<>();
        return statusCreateProduct;
    }

    @Override
    public LiveData<AppointmentsConfirmationResponse> getAppointmentStatus() {
        if (appointmentsConfirmationResponse==null)
            appointmentsConfirmationResponse = new MutableLiveData<>();
        return appointmentsConfirmationResponse;
    }


    //Getters for status for network calls
    public LiveData<Boolean> getStatusExpertAppointmentsResponse(){
        if (statusExpertAppointmentsResponse==null)
            statusExpertAppointmentsResponse = new MutableLiveData<>();
        return statusExpertAppointmentsResponse;
    }

    public LiveData<Boolean> getStatusExpertSingleAppointmentResponse(){
        if (statusExpertSingleAppointmentResponse==null)
            statusExpertSingleAppointmentResponse = new MutableLiveData<>();
        return statusExpertSingleAppointmentResponse;
    }


    public LiveData<Boolean> getStatusConfirmatonAppointments(){
        if (statusAppointments==null)
            statusAppointments = new MutableLiveData<>();
        return statusAppointments;
    }





    public BusinessFunctionViewModel(AppDataManager appDataManager) {
        super(appDataManager);
        this.appDataManager = appDataManager;
    }



    public void getAppointmentsForExpert(){
        if (statusExpertAppointmentsResponse==null)
            statusExpertAppointmentsResponse = new MutableLiveData<>();
        if (expertAppointmentsResonse==null)
            expertAppointmentsResonse = new MutableLiveData<>();


        appDataManager.getAppointmentsForExpert().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<ExpertAppointmentsResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(Response<ExpertAppointmentsResponse> farmerAppointmentsResponseResponse) {
                        if (farmerAppointmentsResponseResponse.code()==200){
                            statusExpertAppointmentsResponse.setValue(true);
                            expertAppointmentsResonse.setValue(farmerAppointmentsResponseResponse.body());
                            Log.d(TAG, "onNext: Successfully retrieved the reponses of appointments");
                        }else{
                            statusExpertAppointmentsResponse.setValue(false);
                            Log.d(TAG, "onNext: Wrong response code" + farmerAppointmentsResponseResponse.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        statusExpertAppointmentsResponse.setValue(false);
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: Appointments method completed");
                    }
                });
    }



    public void getExpertSingleAppointment(String id){

        if (expertSingleAppointmentResponse==null)
            expertSingleAppointmentResponse = new MutableLiveData<>();
        if (statusExpertSingleAppointmentResponse==null)
            statusExpertSingleAppointmentResponse = new MutableLiveData<>();

        appDataManager.getSingleAppointment(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<SingleAppointmentForExpert>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(Response<SingleAppointmentForExpert> AppointmentsResponseResponse) {
                        if (AppointmentsResponseResponse.code()==200){
                            statusExpertSingleAppointmentResponse.setValue(true);
                            expertSingleAppointmentResponse.setValue(AppointmentsResponseResponse.body());
                            Log.d(TAG, "onNext: Successfully retrieved the reponses of appointments");
                        }else{
                            statusExpertSingleAppointmentResponse.setValue(false);
                            Log.d(TAG, "onNext: Wrong response code" + AppointmentsResponseResponse.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        statusExpertSingleAppointmentResponse.setValue(false);
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: Appointments method completed");
                    }
                });



    }

    public void createNewProductServices(ProductsBody body){

        if (statusCreateProduct==null)
            statusCreateProduct = new MutableLiveData<>();


        appDataManager.createNewProduct(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Response<DefaultResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {
                getCompositeDisposable().add(d);
            }

            @Override
            public void onNext(Response<DefaultResponse> defaultResponseResponse) {
                if (defaultResponseResponse.code()==200){
                    statusCreateProduct.setValue(true);
                }else{
                    statusCreateProduct.setValue(false);
                }
            }

            @Override
            public void onError(Throwable e) {
                statusCreateProduct.setValue(false);
            }

            @Override
            public void onComplete() {

            }
        });


    }

    public void sendConfirmation(String cnf_url,boolean status){

        if (statusAppointments==null)
            statusAppointments = new MutableLiveData<>();
        if (appointmentsConfirmationResponse==null)
            appointmentsConfirmationResponse = new MutableLiveData<>();
        appDataManager.getAppointmentsConfirmation(cnf_url, status).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<AppointmentsConfirmationResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(Response<AppointmentsConfirmationResponse> farmerAppointmentsResponseResponse) {
                        if (farmerAppointmentsResponseResponse.code()==200){
                            statusAppointments.setValue(true);
                            appointmentsConfirmationResponse.setValue(farmerAppointmentsResponseResponse.body());
                            Log.d(TAG, "onNext: Successfully retrieved the reponses of appointments");
                        }else{
                            statusAppointments.setValue(false);
                            Log.d(TAG, "onNext: Wrong response code" + farmerAppointmentsResponseResponse.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        statusAppointments.setValue(false);
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: Appointments method completed");
                    }
                });

    }



}
