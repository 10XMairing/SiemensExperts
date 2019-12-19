package com.github.tenx.xservices.ui.Services.equipments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Services.equipments.adapter.EquipmentsAdapter;
import com.github.tenx.xservices.ui.Services.equipments.adapter.EquipmentsDataModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipmentsFragment extends Fragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    EquipmentsAdapter adapter;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;


    private List<EquipmentsDataModel> itemList;

    @Inject
    public EquipmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipments, container, false);
        ButterKnife.bind(this, view);
        AndroidSupportInjection.inject(this);

        //Todo pBar



        setUpRecycler(recyclerView, adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    private void setUpRecycler(RecyclerView recyclerView, EquipmentsAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        adapter.updateListData(loadItems());
    }

    private List<EquipmentsDataModel> loadItems() {
        itemList = new ArrayList<>();

        itemList.add(new EquipmentsDataModel("Benz Tractor", "Texas", "499" ,
                "Guwahati", R.drawable.ic_launcher_foreground));

        itemList.add(new EquipmentsDataModel("Benz Tractor 2", "Texas 2", "500",
                "Guwahati 2", R.drawable.ic_launcher_foreground));
        itemList.add(new EquipmentsDataModel("Benz Tractor 3", "Texas 3", "500",
                "Guwahati 3", R.drawable.ic_launcher_background));
        itemList.add(new EquipmentsDataModel("Benz Tractor 4", "Texas 4", "499",
                "Guwahati 4", R.drawable.ic_launcher_background));


        return itemList;
    }


}
