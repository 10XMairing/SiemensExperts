package com.github.tenx.xservices.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.FunctionActivity;
import com.github.tenx.xservices.ui.Services.ServicesActivity;
import com.github.tenx.xservices.ui.main.recyclerView.HomePageAdapter;
import com.github.tenx.xservices.ui.main.recyclerView.HomePageAdapter2;
import com.github.tenx.xservices.ui.main.recyclerView.HomePageItemsModel;
import com.github.tenx.xservices.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import maes.tech.intentanim.CustomIntent;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";


    @Inject
    MainViewModel mainViewModel;

    @Inject
    HomePageAdapter adapter;

    @Inject
    HomePageAdapter2 adapter2;


    ArrayList<HomePageItemsModel> itemList;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.recycler_view2)
    RecyclerView recyclerView2;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            goToNextActivity(position,true);

            if (mainViewModel == null)
                Log.d(TAG, "onClick: VIEWMODEL IS EMPTY");
            else
                Log.d(TAG, "onClick: VIEWMODEL IS NOT EMPTY");

        }
    };

    private View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            goToNextActivity(position,false);

            if (mainViewModel == null)
                Log.d(TAG, "onClick: VIEWMODEL IS EMPTY");
            else
                Log.d(TAG, "onClick: VIEWMODEL IS NOT EMPTY");

        }
    };




    private void goToNextActivity(int position,boolean flag) {
        if (position == 0 && flag==true) {
            Intent intent = new Intent(this, ServicesActivity.class);
            startActivity(intent);
            CustomIntent.customType(this, "left-to-right");
            return;
        }

        Intent intent = new Intent(this, FunctionActivity.class);
        intent.putExtra(Constants.SELECTED_ID, position);
        intent.putExtra(Constants.FLAG_BUSINESS,flag);
        startActivity(intent);

        CustomIntent.customType(this, "left-to-right");


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AndroidInjection.inject(this);
//        this is neccesary bind call for BindView decorators
        ButterKnife.bind(this);


        setUpRecycler(recyclerView, adapter);
        setUpRecycler2(recyclerView2,adapter2);


        if (mainViewModel == null) {
            Timber.d("View model NOT ok");
        } else {
            Timber.d("View model is locked and loaded!");
        }


    }


    private void setUpRecycler(RecyclerView recyclerView, HomePageAdapter adapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListItems(loadItems());
    }
    private void setUpRecycler2(RecyclerView recyclerView, HomePageAdapter2 adapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener2);
        adapter.updateListItems(loadItems2());
    }

    private List<HomePageItemsModel> loadItems() {
        itemList = new ArrayList<>();
        itemList.add(new HomePageItemsModel(R.drawable.ic_services_purple, "Services"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_shop_purple, "Shop"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_question_mark_purple, "Post a question"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_contact_experts_purple, "Contact the Experts"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_articles_purple, "Articles"));

        return itemList;
    }
    private List<HomePageItemsModel> loadItems2() {
        itemList = new ArrayList<>();
        itemList.add(new HomePageItemsModel(R.drawable.ic_notification_purple, "Notifications"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_prediction_purple, "Predict my Production"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_cart_purple,"Your " +
                "Cart"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_receipt_black_24dp,"Appointments"));
        return itemList;
    }


}
