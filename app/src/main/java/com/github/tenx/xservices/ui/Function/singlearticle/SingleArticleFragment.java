package com.github.tenx.xservices.ui.Function.singlearticle;


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
public class SingleArticleFragment extends Fragment {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_headline)
    TextView tvHeadline;
    @BindView(R.id.tv_desceription)
    TextView tvDesceription;
    @BindView(R.id.iv_advertisement_image)
    ImageView ivAdvertisementImage;

    @Inject
    public SingleArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_article, container, false);
        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this,view);






        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

}
