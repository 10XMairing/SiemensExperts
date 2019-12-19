package com.github.tenx.xservices.ui.business.funcnatilies.newProduct;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.data.models.products.ProductsBody;
import com.github.tenx.xservices.ui.business.funcnatilies.BusinessFunctionViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessNewProductFragment extends Fragment {

    @BindView(R.id.product_name)
    TextInputEditText productName;
    @BindView(R.id.line1)
    TextInputLayout line1;
    @BindView(R.id.product_price)
    TextInputEditText productPrice;
    @BindView(R.id.line2)
    TextInputLayout line2;
    @BindView(R.id.product_discount)
    TextInputEditText productDiscount;
    @BindView(R.id.line4)
    TextInputLayout line4;
    @BindView(R.id.product_descriptionm)
    TextInputEditText productDescriptionm;
    @BindView(R.id.line3)
    TextInputLayout line3;
    @BindView(R.id.iv_equipments_image)
    ImageView ivEquipmentsImage;
    @BindView(R.id.image_btn)
    MaterialButton imageBtn;
    @BindView(R.id.btn_upload)
    MaterialButton btnUpload;

    private static final String TAG = "BusinessNewProductFragm";

    @Inject
    BusinessFunctionViewModel viewModel;
    @BindView(R.id.spin_kit)
    ProgressBar spinKit;
    @BindView(R.id.layout)
    ScrollView layout;


    @Inject
    public BusinessNewProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_new_product, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        subscribeObserverForCreateProduct();

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    private void subscribeObserverForCreateProduct() {
        viewModel.createNewProduct().observe(this, aBoolean -> {
            if (aBoolean) {
                spinKit.setVisibility(View.GONE);
                Snackbar.make(layout,"Product created",Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(layout,"Product creation failed",Snackbar.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick(R.id.btn_upload)
    public void onViewClicked() {

        String Name = productName.getText().toString();
        String description = productDescriptionm.getText().toString();
        int price = Integer.parseInt(productPrice.getText().toString());
        int discount = Integer.parseInt(productDiscount.getText().toString());

        //TODO the network call
        viewModel.createNewProductServices(new ProductsBody(Name, description, price, discount));
        spinKit.setVisibility(View.VISIBLE);
    }
}
