package com.github.tenx.xservices.ui.Function.singleItemShop;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.cart.CartFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleItemShopFragment extends Fragment {


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
    @BindView(R.id.btn_cart)
    MaterialButton btnCart;
    @BindView(R.id.name_layout)
    LinearLayout nameLayout;

    @Inject
    CartFragment cartFragment;

    @Inject
    public SingleItemShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_item_shop, container, false);

        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);


        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @OnClick({R.id.btn_cart, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cart:
                addToCart();
                break;
            case R.id.btn_buy:
                buyItem();
                break;
        }
    }

    private void addToCart() {

        //TODO add to the cart

        Snackbar.make(nameLayout,"Item added to the cart",Snackbar.LENGTH_SHORT).show();

    }
    private void buyItem(){
        //TODO call addToCart method. Add to cart .. Navigate to the cart
        initializeFragments(cartFragment);
    }

    public void initializeFragments( Fragment frag){
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout,frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }
}
