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
    public TextView title, price, genre;
    LinearLayout itemQuantityLayout, itemTotalPriceLayout;
    public TextView quantity ,txtTotalAmonut  ;

    public MyViewHolder(View view) {
        super(view);

        title = (TextView) view.findViewById(R.id.itemName);
        genre = (TextView) view.findViewById(R.id.genre);
        price = (TextView) view.findViewById(R.id.price);

        itemQuantityLayout = (LinearLayout) view.findViewById(R.id.itemQuantityLayout);
        itemTotalPriceLayout = (LinearLayout) view.findViewById(R.id.itemTotalPriceLayout);
        quantity = (TextView) view.findViewById(R.id.quantity);
        txtTotalAmonut = (TextView) view.findViewById(R.id.txtTotalAmonut);
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
        holder.title.setText(item.getItemName());
        holder.genre.setText(item.getGenre());
        holder.price.setText(""+item.getPrice());
        holder.quantity.setText(""+item.getQuntity());
        holder.txtTotalAmonut.setText(""+item.getTotalAmount());
        if(item.getTotalAmount()==0){

            holder. itemQuantityLayout.setVisibility(View.GONE);
            holder.itemTotalPriceLayout.setVisibility(View.GONE);

        }
        else{
            holder. itemQuantityLayout.setVisibility(View.VISIBLE);
            holder.itemTotalPriceLayout.setVisibility(View.VISIBLE);

        }
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
