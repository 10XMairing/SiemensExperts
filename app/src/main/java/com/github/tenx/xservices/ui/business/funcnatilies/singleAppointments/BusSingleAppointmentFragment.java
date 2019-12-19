package com.github.tenx.xservices.ui.business.funcnatilies.singleAppointments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.data.models.appointments.AppointmentsConfirmationResponse;
import com.github.tenx.xservices.data.models.appointments.SingleAppointmentForExpert;
import com.github.tenx.xservices.ui.business.funcnatilies.BusinessFunctionViewModel;
import com.github.tenx.xservices.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusSingleAppointmentFragment extends Fragment {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.tv_decline)
    TextView tvDecline;
    @BindView(R.id.tv_accept)
    TextView tvAccept;

    String appointment_id = "";

    @Inject
    BusinessFunctionViewModel viewModel;
    @BindView(R.id.spin_kit)
    ProgressBar spinKit;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.status_tv_holder)
    TextView statusTvHolder;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.description)
    TextView description;

    @Inject
    public BusSingleAppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_single_notification, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        appointment_id = getArguments().getString(Constants.APPOINTMENTS_ID);

        viewModel.getExpertSingleAppointment(appointment_id);


        subscribeObserversForSingleAppointment();
        subscribeObserversForAppointmentStatus();
        subscribeObserversForStatusAppointment();
        subscribeObserversForAppointmentStatusCode();

        return view;
    }

    private void subscribeObserversForAppointmentStatusCode() {

        viewModel.getStatusConfirmatonAppointments().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    spinKit.setVisibility(View.GONE);
                    Snackbar.make(layout, "Updated", Snackbar.LENGTH_SHORT).show();
                } else {
                    spinKit.setVisibility(View.GONE);
                    Snackbar.make(layout, "Some occur occured", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void subscribeObserversForStatusAppointment() {
        viewModel.getAppointmentStatus().observe(this, new Observer<AppointmentsConfirmationResponse>() {
            @Override
            public void onChanged(AppointmentsConfirmationResponse singleAppointmentsResponse) {

                boolean b = singleAppointmentsResponse.getmData().isCnfStatus();
                if (b)
                    status.setText("Accepted");
                else
                    status.setText("Rejected");
            }
        });
    }


    private void subscribeObserversForAppointmentStatus() {
        viewModel.getStatusExpertAppointmentsResponse().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    spinKit.setVisibility(View.GONE);
                    Snackbar.make(layout, "Retrieved", Snackbar.LENGTH_SHORT).show();

                } else {
                    Snackbar.make(layout, "Error", Snackbar.LENGTH_SHORT).show();

                }
            }
        });
    }

    //TODO check this

    private void subscribeObserversForSingleAppointment() {
        viewModel.getSingleAppointmentForExpert().observe(this, new Observer<SingleAppointmentForExpert>() {
            @Override
            public void onChanged(SingleAppointmentForExpert singleAppointmentsResponse) {


                String fName = singleAppointmentsResponse.getFarmer().getfName();
                String lName = singleAppointmentsResponse.getFarmer().getlName();
                String fullName = fName+" " + lName;


                name.setText(fullName);
                location.setText(singleAppointmentsResponse.getDescription());
                date.setText(singleAppointmentsResponse.getPrice());
                description.setText(singleAppointmentsResponse.getDescription());

            }
        });
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @OnClick({R.id.tv_decline, R.id.tv_accept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_decline:
                declineAppointment();
                spinKit.setVisibility(View.VISIBLE);
                //  hideButtons();
                break;
            case R.id.tv_accept:
                acceptAppointment();
                spinKit.setVisibility(View.VISIBLE);
                // hideButtons();
                break;
        }
    }

    private void hideButtons() {
        tvDecline.setVisibility(View.GONE);
        tvAccept.setVisibility(View.GONE);
        spinKit.setVisibility(View.VISIBLE);
    }


    private void acceptAppointment() {
        //todo network call
        viewModel.sendConfirmation(appointment_id, true);

    }

    private void declineAppointment() {
        //TODO network call
        viewModel.sendConfirmation(appointment_id, false);
    }
}
