package com.github.tenx.xservices.data;

import android.content.Context;

import com.github.tenx.xservices.data.models.DefaultResponse;
import com.github.tenx.xservices.data.models.appointments.AppointmentsConfirmationResponse;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;
import com.github.tenx.xservices.data.models.appointments.SingleAppointmentForExpert;
import com.github.tenx.xservices.data.models.auth.LoginBody;
import com.github.tenx.xservices.data.models.auth.RegistrationBody;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseExpert;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseService;
import com.github.tenx.xservices.data.models.auth.UpdateExpertBody;
import com.github.tenx.xservices.data.models.products.ProductsBody;
import com.github.tenx.xservices.data.prefs.AppPreferencesHelper;
import com.github.tenx.xservices.data.rest.events.AppEventHelper;
import com.github.tenx.xservices.di.scopes.ApplicationContext;

import org.json.JSONObject;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

public class AppDataManager implements  AppDataManagerHelper{


    private Context context;
    private AppEventHelper eventHelper;
    private AppPreferencesHelper preferencesHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context, AppEventHelper appEventHelper,
                          AppPreferencesHelper preferencesHelper) {
        this.context = context;
        this.eventHelper = appEventHelper;
        this.preferencesHelper = preferencesHelper;
    }


    @Override
    public Observable<Response<JSONObject>> updateExpertprofile(UpdateExpertBody body) {
        return eventHelper.updateExpertprofile(body);
    }

    @Override
    public Observable<Response<RegistrationResponseExpert>> registerExpert(RegistrationBody body) {
        return eventHelper.registerExpert(body);
    }

    @Override
    public Observable<Response<RegistrationResponseExpert>> loginExpert(LoginBody body) {
        return eventHelper.loginExpert(body);
    }


    @Override
    public Observable<Response<RegistrationResponseService>> registerService(RegistrationBody body) {
        return eventHelper.registerService(body);
    }

    @Override
    public Observable<Response<RegistrationResponseService>> loginService(LoginBody body) {
        return eventHelper.loginService(body);
    }

    @Override
    public Observable<Response<ExpertAppointmentsResponse>> getAppointmentsForExpert() {
        return eventHelper.getAppointmentsForExpert();
    }

    @Override
    public Observable<Response<SingleAppointmentForExpert>> getSingleAppointment(String id) {
        return eventHelper.getSingleAppointment(id);
    }

    @Override
    public Observable<Response<DefaultResponse>> createNewProduct(ProductsBody body) {
        return eventHelper.createNewProduct(body);
    }

    @Override
    public Observable<Response<AppointmentsConfirmationResponse>> getAppointmentsConfirmation(String id, boolean cnfStatus) {
        return eventHelper.getAppointmentsConfirmation(id,cnfStatus);
    }


    @Override
    public String getAccessToken() {
        return preferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String token) {
        preferencesHelper.setAccessToken(token);
    }

    @Override
    public void setEmail(String email) {
        preferencesHelper.setEmail(email);
    }

    @Override
    public String getEmail() {
        return preferencesHelper.getEmail();
    }


    @Override
    public void setUserId(String userId) {
        preferencesHelper.setUserId(userId);
    }

    @Override
    public String getUserId() {
        return preferencesHelper.getUserId();
    }


}
