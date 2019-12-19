package com.github.tenx.xservices.ui.Function.cart;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.buyItemFragment.BuyItemFragment;
import com.github.tenx.xservices.ui.Function.cart.adapter.CartDataModel;
import com.github.tenx.xservices.ui.Function.cart.adapter.CartRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    CartRecyclerViewAdapter adapter;

    @Inject
    BuyItemFragment buyItemFragment;

    //TODO resolve dependency cycle
    //TODO I have removed to navigation to a Single Product from the cart. May need to implement.

    ArrayList<CartDataModel> itemList;
    @BindView(R.id.btn_cost)
    TextView btnCost;
    @BindView(R.id.btn_buy)
    Button btnBuy;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            //  goToNextActivity(position);

            // initializeFragments(singleItemShopFragment);
        }
    };


    public void initializeFragments(Fragment frag) {
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout, frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }


    @Inject
    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this, view);

        setUpRecycler(recyclerView, adapter);


        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    private void setUpRecycler(RecyclerView recyclerView, CartRecyclerViewAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListItems(loadItems());
    }

    private List<CartDataModel> loadItems() {
        itemList = new ArrayList<>();
        itemList.add(new CartDataModel("Product 1", 100,
                R.drawable.ic_notification_purple));
        itemList.add(new CartDataModel("Product 2", 100,
                R.drawable.ic_notification_purple));
        itemList.add(new CartDataModel("Product 3", 200,
                R.drawable.ic_notification_purple));
        itemList.add(new CartDataModel("Product 4", 300,
                R.drawable.ic_notification_purple));

        return itemList;
    }


    @OnClick(R.id.btn_buy)
    public void onViewClicked() {

        initializeFragments(buyItemFragment);

    }
}
