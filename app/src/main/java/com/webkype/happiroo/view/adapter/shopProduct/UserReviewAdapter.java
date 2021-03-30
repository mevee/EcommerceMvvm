package com.webkype.happiroo.view.adapter.shopProduct;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.prod_review_resp.Review;
import com.webkype.happiroo.controller.network.responses.product_list.Product;
import com.webkype.happiroo.controller.utils.StringUtil;
import com.webkype.happiroo.databinding.UserProductReviewBinding;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class UserReviewAdapter extends RecyclerView.Adapter<UserReviewAdapter.ViewHolder> {

    private Context context;
    private List<Review> bookList;
    private CommonListener listener;

    public UserReviewAdapter(Context context, List<Review> bookList, CommonListener listener) {
        this.context = context;
        this.listener = listener;
        this.bookList = bookList;

    }


    public void setData() {
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserProductReviewBinding binding = UserProductReviewBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        final UserProductReviewBinding binding = holder.binding;
        final Review books = bookList.get(position);

        Glide.with(context).load(books.getUser_img())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                         binding.userImage.setImageDrawable(context.getResources().getDrawable(R.drawable.image_placeholder));
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                         return false;
                    }
                })
                .into(binding.userImage);

        binding.tvUserName.setText("" + StringUtil.capitalizeFirst(books.getUser_name()));
        binding.tvMessage.setText("" + StringUtil.capitalizeFirst(books.getComments()));

        try {
            if (books.getRating() != null)
             binding.rbProdRateByUser.setRating(Float.valueOf(books.getRating()));
            else  binding.rbProdRateByUser.setRating(0f);
        } catch (NumberFormatException e) {
            binding.rbProdRateByUser.setRating(0f);
        }

    }

    @Override
    public int getItemCount() {
        return (bookList != null ? bookList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        UserProductReviewBinding binding;

        public ViewHolder(@NonNull UserProductReviewBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }


}