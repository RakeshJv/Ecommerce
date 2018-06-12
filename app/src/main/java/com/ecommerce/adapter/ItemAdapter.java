package com.ecommerce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecommerce.R;
import com.ecommerce.model.Merchant;

import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<Merchant> merchantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView shopName,labelAddress,address,labelPhone,phone,
                labelMobilePhone,mobilePhone;

        public MyViewHolder(View view) {
            super(view);
            shopName = (TextView) view.findViewById(R.id.shopName);
            address = (TextView) view.findViewById(R.id.address);
            phone = (TextView) view.findViewById(R.id.phone);
            mobilePhone = (TextView) view.findViewById(R.id.mobilePhone);
        }
    }

    public MenuAdapter(List<Merchant> merchantList) {
        this.merchantList = merchantList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Merchant item = merchantList.get(position);
        holder.shopName.setText(item.getMerchantName());
        holder.address.setText(item.getAddress().getAddress1() +" "+item.getAddress().getAddress2());
        holder.phone.setText(""+item.getContact().getLandLine());
        holder.mobilePhone.setText(""+item.getContact().getMobileNumber());

    }
    @Override
    public int getItemCount() {
        return merchantList.size();
    }
}
