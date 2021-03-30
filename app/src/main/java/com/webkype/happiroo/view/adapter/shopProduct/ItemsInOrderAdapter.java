package com.webkype.happiroo.view.adapter.shopProduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.controller.network.responses.prod_order_detail.Servicedetum;
import com.webkype.happiroo.databinding.ItemInOrderBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsInOrderAdapter extends RecyclerView.Adapter<ItemsInOrderAdapter.ViewHolder> {

    private Context context;
    private List<Servicedetum> productList;

    public ItemsInOrderAdapter(Context context, List<Servicedetum> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInOrderBinding binding = ItemInOrderBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewHolder hd = (ViewHolder) holder;
        final Servicedetum item = productList.get(position);
        final ItemInOrderBinding binding = hd.binding;
        binding.tvPrice.setText("\u20B9" + item.getSellingprice());
        binding.tvProductName.setText(item.getProductname());
//        binding.tvVariant.setText(item.getStatus());
        binding.tvNoOfItems.setText("x" + item.getQuantity());
        Glide.with(context).load(item.getProductimage()).into(binding.ivItemImage);
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemInOrderBinding binding;

        public ViewHolder(@NonNull ItemInOrderBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
