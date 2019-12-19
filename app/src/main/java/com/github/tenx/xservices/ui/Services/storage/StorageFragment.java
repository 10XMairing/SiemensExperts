package com.github.tenx.xservices.ui.Services.storage;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Services.storage.adapter.StorageAdapter;
import com.github.tenx.xservices.ui.Services.storage.adapter.StorageDataModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class StorageFragment extends Fragment {

    private static final String TAG = "StorageFragment";


    @Inject
    StorageAdapter adapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<StorageDataModel> itemList;

    @Inject
    public StorageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_storage, container, false);

        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this,view);

        setUpRecycler(recyclerView,adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    private void setUpRecycler(RecyclerView recyclerView, StorageAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        adapter.updateListData(loadItems());
    }

    private List<StorageDataModel> loadItems() {
        itemList = new ArrayList<>();

        itemList.add(new StorageDataModel("Benz Tractor", "Texas", "499",
                R.drawable.ic_launcher_foreground));

        itemList.add(new StorageDataModel("Benz Tractor 2", "Texas 2", "500 ",
                 R.drawable.ic_launcher_foreground));
        itemList.add(new StorageDataModel("Benz Tractor 3", "Texas 3", "500",
                 R.drawable.ic_launcher_background));
        itemList.add(new StorageDataModel("Benz Tractor 4", "Texas 4", "500",
                 R.drawable.ic_launcher_background));


        return itemList;
    }


}
