package com.github.tenx.xservices.ui.Function.shop.adapter;

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

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.AdvertisementViewHolder> {

    private List<ShopDataModel> mList;
    private View.OnClickListener onItemClickListener;


    @Inject
    public ShopAdapter() {
        mList = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdvertisementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_advertisements,parent,false);
        return new AdvertisementViewHolder(view);
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementViewHolder holder, int position) {

        holder.tvComapny.setText(mList.get(position).getNameCompany());
        holder.tvProduct.setText(mList.get(position).getNameProduct());
        holder.tvDescription.setText(mList.get(position).getAdBody());
        holder.bodyImage.setImageResource(mList.get(position).getAdImage());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListItems(List<ShopDataModel> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }


    public class AdvertisementViewHolder extends RecyclerView.ViewHolder {

        private TextView tvComapny;
        private TextView tvProduct;
        private TextView tvDescription;
        private ImageView bodyImage;


        public AdvertisementViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setTag(this);

            tvComapny = itemView.findViewById(R.id.tv_title);
            tvProduct = itemView.findViewById(R.id.tv_headline);
            tvDescription = itemView.findViewById(R.id.tv_desceription);
            bodyImage = itemView.findViewById(R.id.iv_advertisement_image);

            itemView.setOnClickListener(onItemClickListener);


        }
    }
}
