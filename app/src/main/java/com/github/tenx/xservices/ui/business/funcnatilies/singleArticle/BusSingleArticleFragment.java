package com.github.tenx.xservices.ui.business.funcnatilies.singleArticle;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.business.funcnatilies.BusinessFunctionViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusSingleArticleFragment extends Fragment {


    private static final String TAG = "BusSingleArticleFragmen";
    
    @Inject
    BusinessFunctionViewModel businessFunctionViewModel;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_headline)
    TextView tvHeadline;
    @BindView(R.id.tv_desceription)
    TextView tvDesceription;
    @BindView(R.id.iv_advertisement_image)
    ImageView ivAdvertisementImage;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    public BusSingleArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_single_article, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);
        progressBar.setVisibility(View.VISIBLE);


        
        //TODO when the network call is over make the progressBar GONE


        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


}
