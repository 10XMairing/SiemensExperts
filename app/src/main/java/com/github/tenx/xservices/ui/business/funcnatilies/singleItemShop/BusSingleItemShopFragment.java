package com.github.tenx.xservices.ui.business.funcnatilies.singleItemShop;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.tenx.xservices.R;
import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusSingleItemShopFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_headline)
    TextView tvHeadline;
    @BindView(R.id.tv_desceription)
    TextView tvDesceription;
    @BindView(R.id.iv_advertisement_image)
    ImageView ivAdvertisementImage;
    @BindView(R.id.btn_buy)
    MaterialButton btnBuy;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    public BusSingleItemShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_single_item_shop, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        //TODO take care of the progressBar


        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @OnClick(R.id.btn_buy)
    public void onViewClicked() {
        //TODO the network call
    }
}
