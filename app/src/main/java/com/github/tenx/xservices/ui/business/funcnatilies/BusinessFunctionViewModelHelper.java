package com.github.tenx.xservices.ui.business.funcnatilies;

import androidx.lifecycle.LiveData;

import com.github.tenx.xservices.data.models.DefaultResponse;
import com.github.tenx.xservices.data.models.appointments.AppointmentsConfirmationResponse;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;
import com.github.tenx.xservices.data.models.appointments.SingleAppointmentForExpert;

public interface BusinessFunctionViewModelHelper {

    LiveData<ExpertAppointmentsResponse> getAppointmentsForExperts();

    LiveData<SingleAppointmentForExpert> getSingleAppointmentForExpert();

    LiveData<Boolean> createNewProduct();

    LiveData<AppointmentsConfirmationResponse> getAppointmentStatus();


}
