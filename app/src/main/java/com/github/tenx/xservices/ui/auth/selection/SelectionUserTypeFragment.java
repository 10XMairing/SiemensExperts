package com.github.tenx.xservices.ui.auth.selection;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.auth.registration.RegistrationFragment;
import com.github.tenx.xservices.utils.Constants;
import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectionUserTypeFragment extends Fragment {

    @BindView(R.id.login_expert)
    MaterialButton loginExpert;
    @BindView(R.id.login_services)
    MaterialButton loginServices;

    @Inject
    RegistrationFragment registrationFragment;

    @Inject
    public SelectionUserTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selection_user_type, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @OnClick({R.id.login_expert, R.id.login_services})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_expert:
                nextFrag("Expert");
                break;
            case R.id.login_services:
                nextFrag("Service");
                break;
        }
    }

    private void nextFrag(String expert) {

        Bundle bundle = new Bundle();
        bundle.putString(Constants.USER_TYPE,expert);
        registrationFragment.setArguments(bundle);

        initializeFragments(registrationFragment);

    }
    private void initializeFragments(Fragment frag) {

        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout,frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }

}
