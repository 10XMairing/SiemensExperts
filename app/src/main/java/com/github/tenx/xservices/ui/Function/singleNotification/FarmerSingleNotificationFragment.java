package com.github.tenx.xservices.ui.Function.singleNotification;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.tenx.xservices.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmerSingleNotificationFragment extends Fragment {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.status_tv_holder)
    TextView statusTvHolder;
    @BindView(R.id.status)
    TextView status;

    @Inject
    public FarmerSingleNotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_notification, container, false);

        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this,view);

        return view;
    }


    public void setColor(boolean flag){

        if (flag){

            //TODO set greeen color
        }else{

            //TODO set red color
        }
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

}
