package com.github.tenx.xservices.ui.Services;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Services.equipments.EquipmentsFragment;
import com.github.tenx.xservices.ui.Services.storage.StorageFragment;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import maes.tech.intentanim.CustomIntent;

public class ServicesActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    private static final String TAG = "ServicesActivity";

    @Inject
    ServicesViewModel viewModel;


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    ServicesViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ButterKnife.bind(this);

        AndroidInjection.inject(this);

        Log.d(TAG, "onCreate: "+viewModel.getString());

        setupViewPager();




    }

    private void setupViewPager() {

        adapter = new ServicesViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EquipmentsFragment(), "Lending Equipments");
        adapter.addFragment(new StorageFragment(), "Storage");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;


    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "right-to-left");
    }


}
