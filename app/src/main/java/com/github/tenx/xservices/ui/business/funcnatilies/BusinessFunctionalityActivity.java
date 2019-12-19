package com.github.tenx.xservices.ui.business.funcnatilies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Services.ServicesActivity;
import com.github.tenx.xservices.ui.business.funcnatilies.myarticles.BusinessMyArticleFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.myProducts.BusinessMyProductsFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.appointments.BusinessAppointmentFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.articles.BusinessArticlesFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.notification.NotificationsFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.questions.BusinessQuestionsFragment;
import com.github.tenx.xservices.ui.business.funcnatilies.shop.BusinessShopFragment;
import com.github.tenx.xservices.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import maes.tech.intentanim.CustomIntent;

public class BusinessFunctionalityActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String TAG = "debugBusFunc";


    int flagId =0;
    boolean flagState = false;

    FragmentManager fragmentManager;


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @BindView(R.id.titleText)
    TextView titleText;

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @Inject
    BusinessMyArticleFragment businessMyArticleFragment;

    @Inject
    BusinessMyProductsFragment businessMyProductsFragment;

    @Inject
    BusinessAppointmentFragment businessAppointmentFragment;

    @Inject
    BusinessArticlesFragment businessArticlesFragment;

    @Inject
    BusinessQuestionsFragment businessQuestionsFragment;

    @Inject
    BusinessShopFragment businessShopFragment;
    @Inject
    NotificationsFragment notificationsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_functionality);
        ButterKnife.bind(this);

        AndroidInjection.inject(this);

        flagId = getIntent().getExtras().getInt(Constants.SELECTED_ID);
        flagState = getIntent().getExtras().getBoolean(Constants.FLAG_BUSINESS);

        Log.d(TAG, "onCreate: Flag id::: " + flagId + " flagState ::: " + flagState);


        fragmentManager = getSupportFragmentManager();

        inititalizeFragment(flagId,flagState);


    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;

    }



    private void inititalizeFragment(int flagId,boolean flag) {

        if (flag) {

            switch (flagId) {

                case 0:
                   // goToNextActivity();
                    setUpToolBar("Services");
                    break;
                case 1:
                    initFrag(businessShopFragment);
                    setUpToolBar("Shop");
                    break;
                case 2:
                    initFrag(businessArticlesFragment);
                    setUpToolBar("Articles");
                    break;

            }
        } else {
            switch (flagId) {

                case 0:
                    Log.d(TAG, "inititalizeFragment: Triggered :::::: ");
                    initFrag(businessAppointmentFragment);
                    setUpToolBar("Appointments");
                    break;
                case 1:
                    Log.d(TAG, "inititalizeFragment: Triggered :::::: 1111");
                    initFrag(businessQuestionsFragment);
                    setUpToolBar("Questions");
                    break;
                case 2:
                    Log.d(TAG, "inititalizeFragment: Triggered :::::: 22222");
                    initFrag(businessMyProductsFragment);
                    setUpToolBar("My Products");
                    break;
                case 3:
                    Log.d(TAG, "inititalizeFragment: Triggered :::::: 3333");
                    initFrag(businessMyArticleFragment);
                    setUpToolBar("My Articles");
                    break;
                case 4:
                    initFrag(notificationsFragment);
                    setUpToolBar("Notifications");
                    break;
                    default:
                        initFrag(businessQuestionsFragment);
                        setUpToolBar("Appointments");
                        break;

            }

        }
    }

    private void setUpToolBar(String title) {
        titleText.setText(title);

    }

    private void initFrag(Fragment fragment) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right);
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();

    }

    private void goToNextActivity() {

        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
        CustomIntent.customType(this, "left-to-right");


    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "right-to-left");
    }


}
