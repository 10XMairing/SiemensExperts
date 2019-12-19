package com.github.tenx.xservices.ui.main.recyclerView;


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

public class HomePageAdapter2 extends RecyclerView.Adapter<HomePageAdapter2.HomePageViewHolder>{

    private List<HomePageItemsModel> mList;
    private View.OnClickListener onItemClickListener;

    private static final String TAG = "ArticlesAdapter";

    @Inject
    public HomePageAdapter2(){
        mList = new ArrayList<>();
    }


    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public HomePageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_home,parent,false);
        return new HomePageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListItems(List<HomePageItemsModel> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }



    public class HomePageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;


        public HomePageViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setTag(this);

            imageView = itemView.findViewById(R.id.iv_topic);
            textView = itemView.findViewById(R.id.tv_topic);
            itemView.setOnClickListener(onItemClickListener);

        }
    }
}
