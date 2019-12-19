package com.github.tenx.xservices.ui.business.funcnatilies.appointments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsBody;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;
import com.github.tenx.xservices.ui.business.funcnatilies.BusinessFunctionViewModel;
import com.github.tenx.xservices.ui.business.funcnatilies.appointments.adapter.ExpertAppointmentsAdapter;
import com.github.tenx.xservices.ui.business.funcnatilies.singleAppointments.BusSingleAppointmentFragment;
import com.github.tenx.xservices.utils.Constants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessAppointmentFragment extends Fragment {

    @Inject
    ExpertAppointmentsAdapter adapter;

    @Inject
    BusinessFunctionViewModel viewModel;

    @Inject
    BusSingleAppointmentFragment busSingleAppointmentFragment;

    private static final String TAG = "BusinessAppointmentFrag";
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    ArrayList<ExpertAppointmentsResponse.AppointmentBody> itemList;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            //  goToNextActivity(position);
            String appointment_id =  itemList.get(position).getId();


            initializeFragments(busSingleAppointmentFragment,appointment_id);
        }
    };


    public void initializeFragments(Fragment frag, String appointment_id) {
        String backStateName = frag.getClass().toString();


        Bundle bundle = new Bundle();
        bundle.putString(Constants.APPOINTMENTS_ID, appointment_id);
        frag.setArguments(bundle);


        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout, frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


    @Inject
    public BusinessAppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_appointment, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);
        progressBar.setVisibility(View.VISIBLE);


        setUpRecycler(recyclerView, adapter);
        viewModel.getAppointmentsForExpert();

        subscribeObserversForAppointmentsList();
        subscribeObserversForAppointmentStatus();


        return view;
    }


    private void subscribeObserversForAppointmentStatus() {
        viewModel.getStatusExpertAppointmentsResponse().observe(this, aBoolean -> {
            if (aBoolean) {
                progressBar.setVisibility(View.GONE);

            } else {

            }
        });
    }

    //TODO check this

    private void subscribeObserversForAppointmentsList() {
        viewModel.getAppointmentsForExperts().observe(this, farmerAppointmentsResponse -> {
            itemList = farmerAppointmentsResponse.getmList();

            Log.d(TAG, "onChanged: " + itemList.size());

            adapter.updateListItems(itemList);

        });
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    private void setUpRecycler(RecyclerView recyclerView, ExpertAppointmentsAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);

    }


}
