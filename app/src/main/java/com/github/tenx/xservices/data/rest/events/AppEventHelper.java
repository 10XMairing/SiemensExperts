package com.github.tenx.xservices.data.rest.events;

import com.github.tenx.xservices.data.models.DefaultResponse;
import com.github.tenx.xservices.data.models.appointments.AppointmentsConfirmationResponse;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;
import com.github.tenx.xservices.data.models.appointments.SingleAppointmentForExpert;
import com.github.tenx.xservices.data.models.auth.LoginBody;
import com.github.tenx.xservices.data.models.auth.RegistrationBody;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseExpert;
import com.github.tenx.xservices.data.models.auth.RegistrationResponseService;
import com.github.tenx.xservices.data.models.products.ProductsBody;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppEventHelper implements  EventsApiService {
    private static AppEventHelper instance;
    private EventsApiService api;


    @Inject
    public AppEventHelper(Retrofit retrofit) {
        api = retrofit.create(EventsApiService.class);
    }

    @Override
    public Observable<Response<RegistrationResponseExpert>> registerExpert(RegistrationBody body) {
        return api.registerExpert(body);
    }

    @Override
    public Observable<Response<RegistrationResponseExpert>> loginExpert(LoginBody body) {
        return api.loginExpert(body);
    }

    @Override
    public Observable<Response<RegistrationResponseService>> registerService(RegistrationBody body) {
        return api.registerService(body);
    }

    @Override
    public Observable<Response<RegistrationResponseService>> loginService(LoginBody body) {
        return api.loginService(body);
    }

    @Override
    public Observable<Response<ExpertAppointmentsResponse>> getAppointmentsForExpert() {
        return api.getAppointmentsForExpert();
    }

    @Override
    public Observable<Response<SingleAppointmentForExpert>> getSingleAppointment(String id) {
        return api.getSingleAppointment(id);
    }

    @Override
    public Observable<Response<DefaultResponse>> createNewProduct(ProductsBody body) {
        return api.createNewProduct(body);
    }

    @Override
    public Observable<Response<AppointmentsConfirmationResponse>> getAppointmentsConfirmation(String id, boolean cnfStatus) {
        return api.getAppointmentsConfirmation(id,cnfStatus);
    }


}
