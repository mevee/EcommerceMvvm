package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.webkype.happiroo.controller.network.responses.mservices.ReviewItem;
import com.webkype.happiroo.databinding.ReviewItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerReviewAdapter extends RecyclerView.Adapter<CustomerReviewAdapter.ViewHolder> {

    private Context context;
    private List<ReviewItem> productList;

    public CustomerReviewAdapter(Context context, List<ReviewItem> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReviewItemBinding binding = ReviewItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ReviewItem data = productList.get(position);
        final ReviewItemBinding binding = holder.binding;

        binding.reviewerNameTV.setText(data.getUsername());
        binding.reviewDateTV.setText(data.getReviewdate());
        float raiting = 0;
        try {
            raiting = Float.parseFloat(data.getRating());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        binding.reviewRatingRB.setRating(raiting);
        binding.reviewerDescTV.setText(data.getComments());
//        holder.originalProductPrice.setPaintFlags(holder.originalProductPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ReviewItemBinding binding;

        public ViewHolder(@NonNull ReviewItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
