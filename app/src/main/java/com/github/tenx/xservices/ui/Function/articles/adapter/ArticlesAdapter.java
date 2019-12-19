package com.github.tenx.xservices.ui.Function.articles.adapter;

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

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>{

    private List<ArticlesDataModel> mList;
    private View.OnClickListener onItemClickListener;

    private static final String TAG = "ArticlesAdapter";

    @Inject
    public ArticlesAdapter(){
        mList = new ArrayList<>();
    }


    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_experts,parent,false);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListItems(List<ArticlesDataModel> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }



    public class ArticlesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;


        public ArticlesViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setTag(this);

            imageView = itemView.findViewById(R.id.iv_topic);
            textView = itemView.findViewById(R.id.tv_topic);
            itemView.setOnClickListener(onItemClickListener);

        }
    }
}
