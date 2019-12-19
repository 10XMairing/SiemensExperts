package com.github.tenx.xservices.ui.Services.equipments.adapter;

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

public class EquipmentsAdapter extends RecyclerView.Adapter<EquipmentsAdapter.EquipmentsViewHolder> {

    private List<EquipmentsDataModel> mList;

    @Inject
    public EquipmentsAdapter() {
        mList = new ArrayList<>();

    }

    @NonNull
    @Override
    public EquipmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_lending_equipments,parent,false);
        return new EquipmentsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EquipmentsViewHolder holder, int position) {
        holder.productImage.setImageResource(mList.get(position).getImage());
        holder.productLocation.setText(mList.get(position).getLocation());
        holder.productPrice.setText(mList.get(position).getPrice());
        holder.productManufacturer.setText(mList.get(position).getManufacturer());
        holder.productName.setText(mList.get(position).getProduct());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public void updateListData(List<EquipmentsDataModel>  mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();

    }

    public class EquipmentsViewHolder extends RecyclerView.ViewHolder {



        TextView productName;
        TextView productManufacturer;
        TextView productPrice;
        TextView productLocation;
        ImageView productImage;


        public EquipmentsViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tv_product);
            productManufacturer = itemView.findViewById(R.id.tv_manufactuerer);
            productPrice = itemView.findViewById(R.id.tv_price_main);
            productLocation = itemView.findViewById(R.id.tv_location);
            productImage = itemView.findViewById(R.id.iv_equipments_image);



        }
    }
}
