package com.github.tenx.xservices.ui.business.funcnatilies.appointments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.data.models.appointments.ExpertAppointmentsResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ExpertAppointmentsAdapter extends RecyclerView.Adapter<ExpertAppointmentsAdapter.CartViewHolder> {

    private List<ExpertAppointmentsResponse.AppointmentBody> mList;
    private View.OnClickListener onItemClickListener;

    private static final String TAG = "CartAdapter";

    @Inject
    public ExpertAppointmentsAdapter(){
        mList = new ArrayList<>();
    }


    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_appointments,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        //TODO do the glide part
        //TODO handle full name of the user,description
       // holder.name.setText(mList.get(position).);
//        holder.price.setText(mList.get(position));
      boolean b = mList.get(position).getConfirmStatus();
      if (b)
          holder.price.setText("Accepted");
      else
          holder.price.setText("Rejected");


      String fName = mList.get(position).getFarmer().getfName();
      String lName = mList.get(position).getFarmer().getlName();
      String fullName = fName+" " + lName;

        holder.name.setText(fullName);
        if (mList.get(position).getDescription()!=null)
            holder.price.setText(mList.get(position).getDescription());
//      holder.name.setText(mList.get(position).getExpertId());
//      holder.status.setText(mList.get(position).getFarmerId());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListItems(List<ExpertAppointmentsResponse.AppointmentBody> data){
        mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }



    public class CartViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        ImageView profilePic;
        TextView status;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);

            name = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_notifications_type);
            profilePic = itemView.findViewById(R.id.profile_pic);
            status = itemView.findViewById(R.id.tv_status);


            itemView.setOnClickListener(onItemClickListener);

        }

    }
}
