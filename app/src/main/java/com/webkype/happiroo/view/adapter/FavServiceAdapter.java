package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.mservices.Service;
import com.webkype.happiroo.databinding.FavServiceListBinding;
import com.webkype.happiroo.view.activity.shopService.ServiceProductDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavServiceAdapter extends RecyclerView.Adapter<FavServiceAdapter.ViewHolder> {

    private Context context;
    private List<Service> productList;

    public FavServiceAdapter(Context context, List<Service> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FavServiceListBinding binding = FavServiceListBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Service data = productList.get(position);
        Glide.with(context).load(data.getBanner())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .into(holder.binding.favImageItem);
        holder.binding.productNameItem.setText(data.getServicename());
        holder.binding.tvServiceRating.setText(data.getRating());
        holder.binding.discountedProductPrice.setText("\u20B9" + data.getSellingprice());


        holder.binding.favCardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceProductDetailActivity.class);
                intent.putExtra("catId", data.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        FavServiceListBinding binding;


        public ViewHolder(@NonNull FavServiceListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
