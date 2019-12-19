package com.github.tenx.xservices.ui.business.funcnatilies.notification;


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
import com.github.tenx.xservices.ui.business.funcnatilies.notification.adapter.NotificationDataModel;
import com.github.tenx.xservices.ui.business.funcnatilies.notification.adapter.NotificationRecyclerAdapter;
import com.github.tenx.xservices.ui.business.funcnatilies.singleAppointments.BusSingleAppointmentFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {

    @Inject
    NotificationRecyclerAdapter adapter;

    private static final String TAG = "NotificationsFragment";

    ArrayList<NotificationDataModel> itemList;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    BusSingleAppointmentFragment busSingleAppointmentFragment;




    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            //  goToNextActivity(position);

            initializeFragments(busSingleAppointmentFragment);
        }
    };

    //TODO send the id in a bundle


    public void initializeFragments(Fragment frag) {
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout, frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


    @Inject
    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this,view);

        setUpRecycler(recyclerView,adapter);


        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    private void setUpRecycler(RecyclerView recyclerView, NotificationRecyclerAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListItems(loadItems());
    }

    private List<NotificationDataModel> loadItems() {
        itemList = new ArrayList<>();
        itemList.add(new NotificationDataModel("Person a", "Body a"));
        itemList.add(new NotificationDataModel("Person 2", "Body a"));
        itemList.add(new NotificationDataModel("Person 3", "Body 2"));
        itemList.add(new NotificationDataModel("Person 4", "Body 1"));
        itemList.add(new NotificationDataModel("Person 5", "Body a"));
        return itemList;
    }


}
