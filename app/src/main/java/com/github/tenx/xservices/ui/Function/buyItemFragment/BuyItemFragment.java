package com.github.tenx.xservices.ui.Function.buyItemFragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.payments.FarmerPaymentsFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyItemFragment extends Fragment {


    private static final String TAG = "BuyItemFragment";
    @BindView(R.id.tv_name)
    TextInputEditText tvName;
    @BindView(R.id.tv_time)
    TextInputEditText tvTime;
    @BindView(R.id.tv_special_requirements)
    TextInputEditText tvSpecialRequirements;
    @BindView(R.id.btn_payment)
    MaterialButton btnPayment;

    @Inject
    FarmerPaymentsFragment farmerPaymentsFragment;

    @Inject
    public BuyItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy_item, container, false);

        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @OnClick(R.id.btn_payment)
    public void onViewClicked() {
        initializeFragments(farmerPaymentsFragment);
    }
    public void initializeFragments(Fragment frag) {
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout, frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


}
