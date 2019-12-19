package com.github.tenx.xservices.ui.Services.storage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.StorageViewHolder> {


    private List<StorageDataModel> mList;

    @Inject
    public StorageAdapter() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public StorageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_storage,parent,false );
        return  new StorageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StorageViewHolder holder, int position) {
        holder.storageImage.setImageResource(mList.get(position).getImage());
        holder.storageLocation.setText(mList.get(position).getLocation());
        holder.storageName.setText(mList.get(position).getName());
        holder.storagePrice.setText(mList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListData(List<StorageDataModel>  mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();

    }


    public class StorageViewHolder extends RecyclerView.ViewHolder {

        TextView storageName;
        TextView storagePrice;
        TextView storageLocation;
        ImageView storageImage;

        public StorageViewHolder(@NonNull View itemView) {
            super(itemView);


            storageImage = itemView.findViewById(R.id.iv_storage);
            storagePrice = itemView.findViewById(R.id.tv_price);
            storageLocation = itemView.findViewById(R.id.tv_location);
            storageName = itemView.findViewById(R.id.tv_storage);
        }
    }
}
