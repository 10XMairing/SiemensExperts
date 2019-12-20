package com.github.tenx.xservices.data.rest.events;

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

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EventsApiService {

    @POST("api/expert/register")
    Observable<Response<RegistrationResponseExpert>> registerExpert(@Body RegistrationBody body);

    @PATCH("api/expert/update/me")
    Observable<Response<JSONObject>> updateExpertprofile(@Body UpdateExpertBody body);

    @POST("api/expert/login")
    Observable<Response<RegistrationResponseExpert>> loginExpert(@Body LoginBody body);

    @POST("api/business/register")
    Observable<Response<RegistrationResponseService>> registerService(@Body RegistrationBody body);

    @POST("api/business/login")
    Observable<Response<RegistrationResponseService>> loginService(@Body LoginBody body);

    @GET("api/appointment/expert/me")
    Observable<Response<ExpertAppointmentsResponse>> getAppointmentsForExpert();

    @GET("api/appointment/{appointment_id}")
    Observable<Response<SingleAppointmentForExpert>>
    getSingleAppointment(@Path("appointment_id") String id);


    @POST("api/product/create")
    Observable<Response<DefaultResponse>> createNewProduct(@Body ProductsBody body);


    @POST("api/appointment/{appointment_id}/confirm={confirm_status}")
    Observable<Response<AppointmentsConfirmationResponse>> getAppointmentsConfirmation(
            @Path("appointment_id") String id, @Path("confirm_status") boolean cnfStatus);


}
