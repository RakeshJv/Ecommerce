package com.ecommerce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecommerce.R;

import java.util.List;

/**
 * Created by Rvaishya on 2/24/2018.
 */

public class MenuAdapter  extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
private List<Menu> itemList;

public class MyViewHolder extends RecyclerView.ViewHolder {


//    public TextView title, price, genre;
//    LinearLayout itemQuantityLayout, itemTotalPriceLayout;
//    public TextView quantity ,txtTotalAmonut  ;


    public  TextView shopName,labelAddress,address,labelPhone,phone,

    labelMobilePhone,mobilePhone;





    public MyViewHolder(View view) {
        super(view);

        shopName = (TextView) view.findViewById(R.id.shopName);
        address = (TextView) view.findViewById(R.id.address);
        phone = (TextView) view.findViewById(R.id.phone);
        mobilePhone = (TextView) view.findViewById(R.id.mobilePhone);
    }
}

    public MenuAdapter(List<Menu> moviesList) {
        this.itemList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu item = itemList.get(position);
        holder.shopName.setText(item.getItemName());
        holder.address.setText(item.getGenre());
        holder.phone.setText(""+item.getPrice());
        holder.mobilePhone.setText(""+item.getQuntity());

}
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
