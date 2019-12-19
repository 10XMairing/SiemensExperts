package com.github.tenx.xservices.ui.Function.contactExperts;


import android.Manifest;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.contactExperts.adapter.ContactExpertsAdapter;
import com.github.tenx.xservices.ui.Function.contactExperts.adapter.ContactExpertsDataModel;
import com.github.tenx.xservices.ui.Function.singleExpert.SingleExpertFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactExpertsFragment extends Fragment {

    private static final String TAG = "ContactExpertsFragment";

    @BindView(R.id.locationText)
    EditText locationText;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.btn_search)
    MaterialButton btnSearch;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    ContactExpertsAdapter adapter;


    ArrayList<ContactExpertsDataModel> itemList;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    @Inject
    SingleExpertFragment singleExpertFragment;

    private FusedLocationProviderClient fusedLocationProviderClient;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            //  goToNextActivity(position);

             initializeFragments(singleExpertFragment);
        }
    };

    private void initializeFragments(SingleExpertFragment frag) {

        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout,frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


    @Inject
    public ContactExpertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_experts, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);
        progressbar.setVisibility(View.INVISIBLE);


        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    private void setUpRecycler(RecyclerView recyclerView, ContactExpertsAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListData(loadItems());
    }

    private List<ContactExpertsDataModel> loadItems() {
        itemList = new ArrayList<>();
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "article 1"));
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "Article 2"));
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "Article 3"));
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "Article 4"));
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "Articvle 5"));
        itemList.add(new ContactExpertsDataModel(R.drawable.ic_launcher_foreground, "Articles"));
        return itemList;
    }


    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        progressbar.setVisibility(View.VISIBLE);
        setUpRecycler(recyclerView, adapter);
        progressbar.setVisibility(View.GONE);

    }

    @OnClick(R.id.iv_location)
    public void onLocationClicked() {
        attemptPermission();

    }

    private void attemptPermission() {

        Dexter.withActivity(getActivity()).withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                attemptLocation();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }
        }).check();
    }

    private void attemptLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());

        try{

            Task location = fusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful()){
                        Log.d(TAG, "onComplete: found location..");
                        Location currentLocation = (Location) task.getResult();
                        Log.d(TAG, "onComplete: LAtitude is : " + currentLocation.getLatitude() +
                                " Longitude  : " + currentLocation.getLongitude());

                        getAddressFromLocation(currentLocation.getLatitude(),currentLocation.getLongitude());
                    }else{
                        Log.d(TAG, "onComplete: curretn location is null");
                        Toast.makeText(getActivity(),"Unable to get location",Toast.LENGTH_SHORT).show();
                    }
                }
            }) ;


        }catch (SecurityException e){
            Log.d(TAG, "attemptLocation: Security Exception : " + e.getMessage());
        }
    }

    private void getAddressFromLocation(double latitude, double longitude) {

        Geocoder geocoder = new Geocoder(getContext(), Locale.ENGLISH);


        try{
            List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);

            if (addresses.size()>0){
                Address fetchedAddress = addresses.get(0);
                StringBuilder strAddress = new StringBuilder();

//                for(int i =0 ;i<fetchedAddress.getMaxAddressLineIndex();i++){
//
//                    strAddress.append(fetchedAddress.getLocality()).append(" ");
//                }

                Log.d(TAG, "getAddressFromLocation: LOCALITY IS : " + fetchedAddress.getLocality());

                locationText.setText(fetchedAddress.getLocality());


            }else{
                Log.d(TAG, "getAddressFromLocation: Searching for location" );
            }


        }catch (IOException e){
            e.printStackTrace();
            Log.d(TAG, "getAddressFromLocation: COuld not get Address");
        }
    }



}
