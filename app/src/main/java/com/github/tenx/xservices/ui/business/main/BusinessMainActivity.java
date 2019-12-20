package com.github.tenx.xservices.ui.business.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.business.funcnatilies.BusinessFunctionalityActivity;
import com.github.tenx.xservices.ui.business.main.recyclerView.HomePageAdapter2;
import com.github.tenx.xservices.ui.main.recyclerView.HomePageAdapter;
import com.github.tenx.xservices.ui.main.recyclerView.HomePageItemsModel;
import com.github.tenx.xservices.utils.Constants;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import maes.tech.intentanim.CustomIntent;
import timber.log.Timber;

public class BusinessMainActivity extends AppCompatActivity {


    @Inject
    HomePageAdapter adapter;

    @Inject
    HomePageAdapter2 adapter2;

    @Inject
    BusinessMainViewModel mainViewModel;

    private static final String TAG = "BusinessMainActivityLog";



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

            if (mainViewModel==null)
                Log.d(TAG, "onClick: VIEWMODEL IS EMPTY");
            else
                Log.d(TAG, "onClick: VIEWMODEL IS NOT EMPTY");

        }
    };
    private View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();


            int pos = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: ONCLICKKKKKKK ::: POSITION :::::  "+ pos);
            goToNextActivity(pos,false);

        }
    } ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_main);
        AndroidInjection.inject(this);


        ButterKnife.bind(this);


        setUpRecycler(recyclerView,adapter);
        setUpRecycler2(recyclerView2,adapter2);


        if (mainViewModel == null) {
            Timber.d("View model NOT ok");
        } else {
            Timber.d("View model is locked and loaded!");
        }





    }

    private void setUpRecycler2(RecyclerView recyclerView, HomePageAdapter2 adapter2) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter2);
        adapter2.setOnItemClickListener(onClickListener2);
        adapter2.updateListItems(loadItems2());

    }


    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this,"right-to-left");
    }


    private void goToNextActivity(int position,boolean flag) {
        if (position==0 && flag==true){
           // Intent intent = new Intent(this, ServicesActivity.class);

          //  startActivity(intent);
            CustomIntent.customType(this,"left-to-right");
            return;
        }

        Intent intent = new Intent(this, BusinessFunctionalityActivity.class);
        intent.putExtra(Constants.SELECTED_ID,position);
        intent.putExtra(Constants.FLAG_BUSINESS,flag);
        startActivity(intent);

        CustomIntent.customType(this,"left-to-right");
        setUpNotification();

    }


    private void setUpRecycler(RecyclerView recyclerView, HomePageAdapter adapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListItems(loadItems1());

    }

    private List<HomePageItemsModel> loadItems1() {
        itemList = new ArrayList<>();
        itemList.add(new HomePageItemsModel(R.drawable.ic_services_purple,"Services"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_shop_purple,"Shop"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_articles_purple,"Articles"));
        return itemList;
    }


    private List<HomePageItemsModel> loadItems2() {
        itemList = new ArrayList<>();
        itemList.add(new HomePageItemsModel(R.drawable.ic_receipt_black_24dp,"Appointments"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_question_mark_purple,"Questions"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_build_black_24dp,"My Products/Services"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_mode_edit_black_24dp,"My Articles"));
        itemList.add(new HomePageItemsModel(R.drawable.ic_notification_purple,"Notifications"));
        return itemList;
    }

    private  void setUpNotification(){
        Log.d(TAG, "setUpNotification: ");
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                        return;
                    }

                    // Get new Instance ID token
                    String token = task.getResult().getToken();
                    mainViewModel.uploadToken(token);

                    Timber.d("Generated Token : "+token);
//                        send to server
                });
        FirebaseMessaging.getInstance().subscribeToTopic("business").addOnSuccessListener(msg -> {
            Timber.d("subscribed to topic : farmer");
        });
    }

}
