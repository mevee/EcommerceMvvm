package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.ImageModel;
import com.webkype.happiroo.controller.network.responses.booking.Bookinglist;
import com.webkype.happiroo.databinding.BookingOngoingBinding;
import com.webkype.happiroo.databinding.ImageItemBinding;
import com.webkype.happiroo.view.activity.bookings.BookingDetailActivity;

import java.util.List;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ViewHolder> {

    private Context context;
    private List<ImageModel> productList;

    public ImageViewAdapter(Context context, List<ImageModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ImageItemBinding binding = ImageItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ImageModel item = productList.get(position);
        final ImageItemBinding binding = holder.binding;
//        binding.sliderRelativeLayout.setPadding(10, 10, 10, 20);
//        binding.sliderRelativeLayout.margsetMaPadding(10, 10, 10, 20);

        Glide.with(context).load(item.getImage())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        binding.bannersProgressBar.setVisibility(View.GONE);
                        binding.ivSlider.setImageDrawable(context.getResources().getDrawable(R.drawable.image_placeholder));
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        binding.bannersProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(binding.ivSlider);

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageItemBinding binding;


        public ViewHolder(@NonNull ImageItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
